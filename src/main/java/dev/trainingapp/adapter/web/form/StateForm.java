package dev.trainingapp.adapter.web.form;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StateForm {
    private String id;
    private String name;

    public static List<StateForm> stateAll() {
       final List<StateForm> states = new ArrayList<>();

        StateForm state = new StateForm();
        state.id = "1";
        state.name = "北海道";
        states.add(state);

        StateForm state1 = new StateForm();
        state1.id = "2";
        state1.name = "秋田";
        states.add(state1);
        return states;
    }
}
