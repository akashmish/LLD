package com.travelpackage.triptonic.models;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Destination {
    private String name;
    private Integer destinationId;
    private List<Activity> availableActivties;
}
