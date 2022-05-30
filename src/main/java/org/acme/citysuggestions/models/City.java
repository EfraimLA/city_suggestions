package org.acme.citysuggestions.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cities")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String ascii;

    private String altName;

    @Column(name = "lat")
    private String latitude;

    @Column(name = "long")
    private String longitude;

    @Column(name = "feat_class")
    private String featClass;

    @Column(name = "feat_code")
    private String featCode;

    @Column(name = "country")
    private String countryCode;

    private String cc2;

    private String admin1;

    private String admin2;

    private String admin3;

    private String admin4;

    private Integer population;

    private Integer elevation;

    private Integer dem;

    @Column(name = "tz")
    private String timeZone;

    @Column(name = "modified_at")
    private Date modifiedAt;

}
