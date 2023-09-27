package com.design.design.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString
public class InterfaceDevice {
    private String name;
    private String location;
    private String activationCommand;
    private DeviceInfoUpdate deviceInfoUpdate;

}
