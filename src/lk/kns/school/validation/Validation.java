package lk.kns.school.validation;

public enum Validation {
    EMAIL() {
        @Override
        public String validate() {
            return "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        }

    },
    MOBILE() {
        @Override
        public String validate() {
            return "^(0{1})(7{1})([0|1|2|4|5|6|7|8]{1})([0-9]{7})";
        }

    },
    PASSWORD() {
        @Override
        public String validate() {
            return "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{6,8}$";
        }

    };

    public String validate() {
        return "";
    }

}
