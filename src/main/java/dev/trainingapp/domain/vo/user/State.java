package dev.trainingapp.domain.vo.user;

import dev.trainingapp.other.enums.ConstApp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;

import java.io.Serializable;

@AllArgsConstructor(staticName = "of")
@Value
public class State implements Serializable {
    private static final long serialVersionUID = 1L;
    private final ConstApp.State code;

    public static State of(Integer code) {
        return State.of(ConstApp.State.getState(code));
    }

    @Value
    @Builder
    public static class ViewState {
        private Integer id;
        private String name;

        public static ImmutableList<ViewState> getAllState() {
            return Lists.immutable.of(ConstApp.State.values())
                    .collect(state -> ViewState.builder().id(state.getPrefectureCd()).name(state.getName()).build());
        }


    }

}
