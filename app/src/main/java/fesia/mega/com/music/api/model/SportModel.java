package fesia.mega.com.music.api.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SportModel {

    public class Example {

        @SerializedName("sports")
        @Expose
        private List<Sport> sports = null;

        public List<Sport> getSports() {
            return sports;
        }

        public void setSports(List<Sport> sports) {
            this.sports = sports;
        }

    }
}
