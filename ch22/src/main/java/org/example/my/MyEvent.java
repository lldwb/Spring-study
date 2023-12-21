package org.example.my;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyEvent {
    /**
     * 事件
     */
    private String message;
}
