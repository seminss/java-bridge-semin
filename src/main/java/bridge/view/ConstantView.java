package bridge.view;

public enum ConstantView {
    START("다리 건너기 게임을 시작합니다.\n"),
    SIZE("다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    END("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private String message;
    public String getMessage(){
        return message;
    }
    ConstantView(String message){
        this.message=message;
    }
}
