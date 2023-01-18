package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput=Console.readLine();
        int bridgeSize=isNum(userInput);
        if (bridgeSize<3 || bridgeSize>20){
            throw new IllegalArgumentException("[ERROR]: 범위를 벗어난 숫자입니다.");
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String howMove=Console.readLine();
        isString(howMove);
        if(!howMove.equals("U")&&!howMove.equals("D")){
            throw new IllegalArgumentException("[ERROR]: U 또는 D만 입력해주세요.");
        }
        return howMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String replay=Console.readLine();
        isString(replay);
        if(!replay.equals("R")&&!replay.equals("Q")){
            throw new IllegalArgumentException("[ERROR]: R 또는 Q만 입력해주세요.");
        }
        return replay;
    }


    /**
     * 사용자 입력이 숫자인지 판단한다.
     */
    public int isNum(String userInput){
        try{ int bridgeSize=Integer.parseInt(userInput);
        return bridgeSize;
        }catch(Exception e) {
            throw new IllegalArgumentException("[ERROR]: 숫자를 입력해 주세요.");
        }
    }

    /**
     * 사용자 입력이 문자인지 판단한다.
     */
    public void isString(String userInput){
        try{ Integer.parseInt(userInput);
        }catch(Exception e){ //String 이라면 에러나는게 정상
            return;
        }
        throw new IllegalArgumentException("[ERROR]: 문자를 입력해 주세요.");
    }
}
