package bridge;

import bridge.maker.BridgeMaker;
import bridge.maker.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UnitTest {

    @DisplayName("시도 횟수 테스트")
    @Test
    void tryCntTest(){
        //when
        List<String> bridge = Arrays.asList("U", "D", "D");

    }

    @DisplayName("다리 생성 테스트")
    @Test
    void bridgeMakerTest(){
        //given
        final int size=4;
        final BridgeRandomNumberGenerator randomNumberGenerator= new BridgeRandomNumberGenerator();
        final BridgeMaker bridgeMaker=new BridgeMaker(randomNumberGenerator);
        //when
        List<String> bridge = bridgeMaker.makeBridge(size);
        //then
        System.out.println(bridge);
    }

    @DisplayName("다리 건너기 테스트")
    @Test
    void bridgeMoveTest(){
        //given
        final int size=3;
        final BridgeRandomNumberGenerator randomNumberGenerator= new BridgeRandomNumberGenerator();
        final BridgeMaker bridgeMaker=new BridgeMaker(randomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        final BridgeGame bridgeGame=new BridgeGame(bridge);

        //when
        System.out.println(bridge);
        System.out.println(bridgeGame.getTmpCnt());
        if(bridgeGame.checkMove("U")){
            System.out.println("U가 맞다");
        }
        if(bridgeGame.checkMove("D")){
            System.out.println("D가 맞다");
        }

        //then
        //success cnt 증가했나
        System.out.println(bridgeGame.getTmpCnt());
    }


}
