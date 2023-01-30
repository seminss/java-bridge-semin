package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                String userInput = Console.readLine();
                int bridgeSize = isNum(userInput);
                if (bridgeSize < 3 || bridgeSize > 20) {
                    throw new IllegalArgumentException();
                }
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try{
                String howMove = Console.readLine();
                if (!howMove.equals("U") && !howMove.equals("D")) {
                    throw new IllegalArgumentException();
                }
                return howMove;
            }catch (Exception e){
                System.out.println("[ERROR] U 또는 D만 입력해주세요.");
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try{
                String replay = Console.readLine();
                if (!replay.equals("R") && !replay.equals("Q")) {
                    throw new IllegalArgumentException();
                }
                return replay;
            }catch (Exception e){
                System.out.println("[ERROR] R 또는 Q만 입력해주세요.");
            }
        }
    }


    /**
     * 사용자 입력이 숫자인지 판단한다.
     */
    public int isNum(String userInput) {
        while (true) {
            try {
                int bridgeSize = Integer.parseInt(userInput);
                return bridgeSize;
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
    }

}