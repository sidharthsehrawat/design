package com.design.design.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SmartHomeDevice {
    private String interfaceName; // alexa
    private String Devicename; // Fan
    private String location; // LivingRoom
    private String status; // ON ,  OFF
}
