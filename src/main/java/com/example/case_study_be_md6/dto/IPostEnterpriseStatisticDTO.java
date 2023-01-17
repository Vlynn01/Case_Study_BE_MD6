package com.example.case_study_be_md6.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface IPostEnterpriseStatisticDTO {
    @JsonProperty("name_post")
    String getNamePost();

    @JsonProperty("number_user_apply")
    Integer getNumberUserApply();
}
