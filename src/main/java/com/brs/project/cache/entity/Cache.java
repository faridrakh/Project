package com.brs.project.cache.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "t_cache")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cache {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "SESSION_ID")
    private String sessionId;

    @Column(name = "KEY")
    private String key;

    @Column(name = "VALUE")
    private String value;
}
