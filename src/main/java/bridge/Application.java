package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView=new InputView();
        OutputView outputView=new OutputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator=new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker=new BridgeMaker(bridgeRandomNumberGenerator);

        // 다리 길이 입력
        outputView.printStart();
        outputView.gettingLength();

        // 다리 생성
        int size= inputView.readBridgeSize();
        System.out.println();
        List<String> bridge= bridgeMaker.makeBridge(size);

        int tryCnt=1; //한 게임 당 하나의 다리만 존재하기 때문에 main에서 시도 횟수 세도 됨
        //한 다리에 대한 게임
        while(playGame(inputView, outputView, bridge)){
            tryCnt++;
        };
        System.out.println(tryCnt);
    }

    private static boolean playGame(InputView inputView, OutputView outputView, List<String> bridge) {
            BridgeGame bridgeGame=new BridgeGame(bridge);
//            System.out.println(bridge);

            //어떻게 이동할 지 받기
            while(true){
                outputView.printMoving();
                String nextMove= inputView.readMoving();

                boolean howMove = bridgeGame.move(nextMove);
                if(!howMove){
                    break; // 계속 move 하는게 아니라면 break
                }
            }
            boolean isSuccess= bridgeGame.isSuccess();
            if(isSuccess) {
                //결과 출력, 게임 종료
                System.out.println("게임 성공");
//                outputView.printResult();
                return false;
            }
            else {
                //재시도 여부 입력
                outputView.choiceRestart();
                String restart = inputView.readGameCommand();
                if (!bridgeGame.retry(restart)) {
                    System.out.println("실패");
                    System.out.println(bridge);
                    return false;
                    //결과 출력, 게임 종료
                } else {
                    //재시작, 지금 쓰고 잇는 bridge 재활용, 시도 횟수 +1
                    return true;
                }
            }

        }

    }
