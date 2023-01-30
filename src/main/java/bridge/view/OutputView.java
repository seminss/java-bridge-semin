package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /** 변수로 선언하게 되면, 메서드 인자로 bridge를 안넣어도 돼서 좋지만,,
     * 여긴 output만 처리하는 곳이고,, 이게 되나? 싶음..
     * 근데 인자 수를 3개 이하로 줄이려면 어쩔 수 없었다... */
    private static List<String> bridge;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int tryCount, List<String> bridge, String userInput) {//몇번째 시도인지, bridge, user 입력
        this.bridge = bridge; //bridge 세팅
        System.out.print(ConstantView.OPEN.getMessage()); //"["
        getPreviousState(tryCount, "U"); //현재 입력 전까지의 다리 map 출력
        getThisState(userInput, "U", tryCount); //현재 입력 위치만 출력
        System.out.println(ConstantView.CLOSE.getMessage()); //"]"
        System.out.print(ConstantView.OPEN.getMessage()); //"["
        getPreviousState(tryCount, "D"); //아랫줄도 똑같이
        getThisState(userInput, "D", tryCount);
        System.out.println(ConstantView.CLOSE.getMessage() + "\n");
    }

    /**현재 칸 위치만 출력*/
    private static void getThisState(String userInput, String floor, int tryCount) {
        if (userInput.equals(floor)) {
            if (userInput.equals(bridge.get(tryCount - 1))) {
                System.out.print("O ");
            } else {
                System.out.print("X ");
            }
        } else {
            System.out.print("  ");
        }
    }

    /**이전까지의 결과 출력, 따라서 -1*/
    private static void getPreviousState(int num, String floor) {
        for (int i = 0; i < num - 1; i++) {
            if (bridge.get(i).equals(floor)) {
                System.out.print("O ");
                System.out.print("| ");
            } else {
                System.out.print("  ");
                System.out.print("| ");
            }
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printGameEnding(int num) {
        System.out.println(ConstantView.ENDING.getMessage());
        System.out.print(ConstantView.OPEN.getMessage());
        getFinalState(num, "U");
        System.out.println(ConstantView.CLOSE.getMessage());
        System.out.print(ConstantView.OPEN.getMessage());
        getFinalState(num, "D");
        System.out.println("]\n");
    }

    /** 게임 최종 결과 출력*/
    private static void getFinalState(int num, String floor) {
        for (int i = 0; i < num; i++) {
            if (bridge.get(i).equals(floor)) {
                System.out.print("O ");
            } else {
                System.out.print("  ");
            }
            if (i != num - 1) {
                System.out.print("| ");
            }
        }
    }

    /** 게임 시작 문구 출력 */
    public void printStart() {
        System.out.println(ConstantView.START.getMessage());
    }

    /** 다리 길이 입력 문구 */
    public void gettingLength() {
        System.out.println(ConstantView.SIZE.getMessage());
    }

    /** 이동할 칸 선택 문구 */
    public void printMoving() {
        System.out.println(ConstantView.MOVE.getMessage());
    }

    /** 게임 재시작 여부 확인 문구 출력 */
    public void choiceRestart() {
        System.out.println(ConstantView.END.getMessage());
    }
}
