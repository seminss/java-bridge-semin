package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UnitTest {

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
}
