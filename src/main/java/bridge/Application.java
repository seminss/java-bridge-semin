package bridge;

import bridge.maker.BridgeMaker;
import bridge.maker.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator); //다리 생성

        outputView.printStart(); //시작 문구
        outputView.gettingLength(); //다리 길이 입력
        int size = inputView.readBridgeSize();

        System.out.println();
        List<String> bridge = bridgeMaker.makeBridge(size); // 게임용 다리 생성

        int tryCnt = 1; //한 게임 당 하나의 다리만 존재하기 때문에 main 에서 다리 길이 세기
        BridgeGame bridgeGame = new BridgeGame(bridge); //게임 생성

        while (bridgeGame.playGame(inputView, outputView)) {
            tryCnt++;
        }

        System.out.println("총 시도한 횟수: " + tryCnt);
    }
}
