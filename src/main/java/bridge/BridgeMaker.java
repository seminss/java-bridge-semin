package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    /** 생성자 */
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge=new ArrayList<>();
        int random;
        for(int i=0;i<size;i++){
            random= bridgeNumberGenerator.generate();
            String square=convertNumToString(random);
            bridge.add(square);
        }
        return bridge;
    }

    /** 숫자로 입력받은 랜덤 변수를 U(1),D(0)으로 변환 */
    private String convertNumToString(int num){
        if(num==1) {
            return "U";
        }
        return "D";
    }
}
