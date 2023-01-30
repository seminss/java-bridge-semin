package bridge;

import bridge.maker.BridgeMaker;
import bridge.maker.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        List<String> bridge = getBridge(inputView, outputView, bridgeMaker);
        getPlayGameResult(inputView, outputView, bridge);
    }

    private static void getPlayGameResult(InputView inputView, OutputView outputView, List<String> bridge) {
        int tryCnt = 1; //한 게임 당 하나의 다리만 존재하기 때문에 main 에서 다리 길이 세기
        BridgeGame bridgeGame = new BridgeGame(bridge); //게임 생성
        while (bridgeGame.playGame()) {
            tryCnt++;
        }
        System.out.println("총 시도한 횟수: " + tryCnt);
    }

    private static List<String> getBridge(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        outputView.printStart(); //시작 문구
        outputView.gettingLength(); //다리 길이 입력
        int size = inputView.readBridgeSize();
        System.out.println();
        List<String> bridge = bridgeMaker.makeBridge(size); // 게임용 다리 생성
        return bridge;
    }

}
