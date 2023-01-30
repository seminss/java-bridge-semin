package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private int tmpCnt;
    private boolean success;
    private int successCnt;
    OutputView outputView=new OutputView();

    /**생성자*/
    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.tmpCnt =0;
        this.success =false;
    }

    /**게임 전체 process*/
    public boolean playGame(InputView inputView, OutputView outputView){
        while(true){
            outputView.printMoving();
            String nextMove= inputView.readMoving(); // 다음 이동칸 입력
            if(!move(nextMove)){// 다음 이동칸과 입력 값이 다르다면?
                break;
            }
        }
        successCnt = tmpCnt;
        tmpCnt =0;
        return resultGame(inputView, outputView);
    }

    private boolean resultGame(InputView inputView, OutputView outputView) {
        if(isSuccess()) { //게임 끝까지 성공
            outputView.printResult(successCnt, bridge);
            System.out.println("게임 성공 여부: 성공");
            return false;
        } else { //게임 아직 남음
            outputView.choiceRestart();//재시도 여부 입력
            String restart = inputView.readGameCommand();

            if (!retry(restart)) { //재시작 x
                outputView.printResult(successCnt, bridge);
                System.out.println("게임 성공 여부: 실패");
                return false;
            } else {//재시작, 지금 쓰고 잇는 bridge 재활용, 시도 횟수 +1
                return true;
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userInput) { // U,D
        outputView.printMap(tmpCnt +1,bridge,userInput);
        if (bridge.get(tmpCnt).equals(userInput)){
            this.tmpCnt++;
            if (tmpCnt ==(bridge.size())){
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
        return false; // 게임 종료
    }

    public boolean isSuccess(){
        return success;
    }

    public int getTmpCnt(){
        return tmpCnt;
    }
}
