package com.webank.ai.fatecloud.system.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.webank.ai.fatecloud.system.dao.entity.FederatedJobStatisticsDo;
import com.webank.ai.fatecloud.system.pojo.dto.*;
import com.webank.ai.fatecloud.system.pojo.qo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FederatedJobStatisticsMapper extends BaseMapper<FederatedJobStatisticsDo> {

    List<JobStatisticsOfSiteDimension> getJobStatisticsOfSiteDimension(JobOfSiteDimensionQo jobOfSiteDimensionQo);

    List<JobStatisticOfInstitutionsDimensionDto> getJobStatisticsODimension(JobOfSiteDimensionQo jobOfSiteDimensionQo);

    JobStatisticsSummaryTodayInstitutionsAllDto getJobStatisticsSummaryTodayInstitutionsAll(JobStatisticsSummaryTodayQo jobStatisticsSummaryTodayQo);

    long getJobStatisticsSummaryTodayInstitutionsEachCount(JobStatisticsSummaryTodayQo jobStatisticsSummaryTodayQo);

    List<JobStatisticsSummaryTodayInstitutionsEachDto> getJobStatisticsSummaryTodayInstitutionsEach(@Param(value = "startIndex") long startIndex, @Param(value = "jobStatisticsSummaryTodayQo") JobStatisticsSummaryTodayQo jobStatisticsSummaryTodayQo);

    JobStatisticsSummaryTodaySiteAllDto getJobStatisticsSummaryTodaySiteAll(JobStatisticsSummaryTodaySiteAllQo jobStatisticsSummaryTodaySiteAllQo);

    long getJobStatisticsSummaryTodaySiteEachCount(JobStatisticsSummaryTodaySiteAllQo jobStatisticsSummaryTodaySiteAllQo);

    List<JobStatisticsSummaryTodaySiteEachDto> getJobStatisticsSummaryTodaySiteEach(@Param(value = "startIndex") long startIndex, @Param(value = "jobStatisticsSummaryTodaySiteAllQo") JobStatisticsSummaryTodaySiteAllQo jobStatisticsSummaryTodaySiteAllQo);

    List<JobStatisticsOfSiteDimension> getJobStatisticsOfSiteDimensionForPeriod(JobOfSiteDimensionPeriodQo jobOfSiteDimensionPeriodQo);

    List<JobStatisticOfInstitutionsDimensionDto> getJobStatisticsODimensionForPeriod(JobOfSiteDimensionPeriodQo jobOfSiteDimensionPeriodQo);

    JobStatisticsSummaryTodayInstitutionsAllDto getJobStatisticsSummaryInstitutionsAllForPeriod(JobStatisticsSummaryForPeriodQo jobStatisticsSummaryForPeriodQo);

    long getJobStatisticsSummaryInstitutionsEachForPeriodCount(JobStatisticsSummaryForPeriodQo jobStatisticsSummaryForPeriodQo);

    List<JobStatisticsSummaryTodayInstitutionsEachDto> getJobStatisticsSummaryInstitutionsEachForPeriod(@Param(value = "startIndex") long startIndex, @Param(value = "jobStatisticsSummaryForPeriodQo") JobStatisticsSummaryForPeriodQo jobStatisticsSummaryForPeriodQo);

    JobStatisticsSummaryTodaySiteAllDto getJobStatisticsSummarySiteAllForPeriod(JobStatisticsSummarySiteAllForPeriodQo jobStatisticsSummarySiteAllForPeriodQo);

    long getJobStatisticsSummarySiteEachForPeriodCount(JobStatisticsSummarySiteAllForPeriodQo jobStatisticsSummarySiteAllForPeriodQo);

    List<JobStatisticsSummaryTodaySiteEachDto> getJobStatisticsSummarySiteEachForPeriod(@Param(value = "startIndex") long startIndex, @Param(value = "jobStatisticsSummarySiteAllForPeriodQo") JobStatisticsSummarySiteAllForPeriodQo jobStatisticsSummarySiteAllForPeriodQo);


}