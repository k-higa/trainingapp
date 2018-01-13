package dev.trainingapp.domain.vo.user;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@AllArgsConstructor(staticName = "of")
@Value
public class IconImage implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String icon;

}
