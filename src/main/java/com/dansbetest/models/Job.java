package com.dansbetest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "job")
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String type;
    private String url;
    @JsonProperty("created_at")
    private String createdAt;
    private String company;
    @JsonProperty("company_url")
    private String companyUrl;
    private String location;
    private String title;
    private String description;
    @JsonProperty("how_to_apply")
    private String howToApply;
    @JsonProperty("company_logo")
    private String companyLogo;

}
