<template>
    <div>
        <el-dialog :visible.sync="activDialog" :close-on-click-modal="false" :close-on-press-escape="false" class="activ-dialog" width="1200px">
            <div class="dialog-header">Admin activation</div>
            <div class="dialog-body">
                <el-form ref="activteForm" :model="activteForm" :rules="activteRules" class="activte-form" label-position="left">
                    <div class="text-one">Please enter the administrator invitation link from Cloud Manager</div>
                    <el-form-item prop="link">
                        <el-input v-model="activteForm.link" @blur="decodeLink" type="text" clearable @focus="toclearValid('link')">
                        </el-input>
                    </el-form-item>
                    <div class="text-one">Please bind an administrator account</div>
                    <el-form-item prop="userName">
                        <el-input v-model="activteForm.userName" type='text' clearable @focus="toclearValid('userName')">
                        </el-input>
                    </el-form-item>
                    <div class="text-one">Please enter your password</div>
                    <el-form-item prop="passWord">
                        <el-input  v-model="activteForm.passWord" type='text' clearable @focus="toclearValid('passWord')">
                        </el-input>
                    </el-form-item>
                </el-form>
            </div>
            <div class="dialog-footer">
                <el-button class="sure-btn" type="primary" @click="toActivte">OK</el-button>
                <el-button class="cancel-btn" type="info" @click="activDialog = false">Cancel</el-button>
            </div>
        </el-dialog>
        <el-dialog :visible.sync="okdialog" :close-on-click-modal="false" :close-on-press-escape="false" class="ok-dialog">
            <div class="icon">
                <i v-if="activate" class="el-icon-success"></i>
                <i v-else class="el-icon-warning"></i>
            </div>
            <span v-if="activate">
                <div class="line-text-one" >Activated Successfully !</div>
                <div class="line-text-two">Now you can sign in FATE Cloud with your administrator account.</div>
            </span>
            <span v-else>
                <div class="line-text-one" >Activated Failed !</div>
                <div class="line-text-two">Please re-enter</div>
            </span>
            <div class="dialog-footer">
                <el-button class="ok-btn" type="primary" @click="toOK">OK</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import { decode64, utf8to16 } from '@/utils/base64'
import { activateAct } from '@/api/welcomepage'

export default {
    name: 'home',
    components: {},
    data() {
        return {
            activteForm: {
                link: '',
                userName: '',
                passWord: ''
            },
            activDialog: false, // 激活弹框
            okdialog: false, // 激活是否成功弹框
            activate: false, // 是否激活成功
            activteRules: {
                link: [
                    {
                        required: true,
                        trigger: 'change',
                        validator: (rule, value, callback) => {
                            const name = value.trim()
                            if (name.length === 0) {
                                callback(new Error('Please enter the invitation link'))
                            } else {
                                callback()
                            }
                        }
                    }
                ],
                userName: [
                    {
                        required: true,
                        trigger: 'change',
                        validator: (rule, value, callback) => {
                            const name = value.trim()
                            if (name.length === 0) {
                                callback(new Error('Please enter the username'))
                            } else {
                                callback()
                            }
                        }
                    }
                ],
                passWord: [
                    {
                        required: true,
                        trigger: 'change',
                        validator: (rule, value, callback) => {
                            const password = value.trim()
                            if (password.length === 0) {
                                callback(new Error('Please enter the password'))
                            } else {
                                callback()
                            }
                        }
                    }
                ]
            }
        }
    },
    watch: {},
    computed: {},
    created() {},
    methods: {
        toActivte() {
            this.$refs['activteForm'].validate((valid) => {
                if (valid) {
                    activateAct({ ...this.activteForm }).then(res => {
                        this.okdialog = true
                        this.activate = true
                    }).catch(res => {
                        this.okdialog = true
                        this.activate = false
                    })
                }
            })
        },
        toOK() {
            this.activDialog = false
            this.okdialog = false
        },
        // 单独验证
        toclearValid(type) {
            this.$refs['activteForm'].clearValidate(type)
        },
        decodeLink(value) {
            if (this.activteForm.link) {
                // decode64 编码提取json对象
                let Url = utf8to16(decode64(this.activteForm.link))
                let obj = { ...JSON.parse(Url.split('st=')[1].replace(new RegExp('\\\\', 'g'), '')) }
                this.activteForm.activateUrl = Url
                this.activteForm.appKey = obj.fateManagerUser.secretInfo.key
                this.activteForm.appSecret = obj.fateManagerUser.secretInfo.secret
                this.activteForm.fateManagerId = obj.fateManagerUser.fateManagerId
                this.activteForm.institutions = obj.fateManagerUser.institutions
                this.activteForm.institution = obj.federatedOrganization.institution
                this.activteForm.federatedId = obj.federatedOrganization.id
                this.activteForm.federatedOrganization = obj.federatedOrganization.name
                this.activteForm.federatedUrl = `${Url.split('//')[0]}//${Url.split('//')[1].split('/')[0]}`
            }
        }

    }
}
</script>

<style rel="stylesheet/scss" lang="scss" >
</style>
