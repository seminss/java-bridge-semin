package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private int successCnt;
    private boolean success;

    /**생성자*/
    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.successCnt=0;
        this.success =false;
    }

    /**게임 전체 process*/
    public void playGame(){

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userInput) {
        if (bridge.get(successCnt).equals(userInput)){
            this.successCnt++;
            if (successCnt==(bridge.size())){
                success =true; //게임 전체 성공
                return false; //성공해도 다음 입력은 없어야 하니까
            }
            return true; //성공
        }
        return false; //실패
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInput) {
        if(userInput.equals("R")){
            return  true;
        }
        // 게임 종료
        return false;
    }

    public boolean isSuccess(){
        return success;
    }

    public int getSuccessCnt(){
        return successCnt;
    }
}
