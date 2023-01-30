package bridge.view;

import org.assertj.core.internal.ComparatorBasedComparisonStrategy;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int num, List<String> bridge, String userInput) {//몇번째 시도인지
        System.out.print("[ ");
        for(int i=0;i<num-1;i++){//현재까지 결과 출력
            if (bridge.get(i).equals("U")){
                System.out.print("O ");
                System.out.print("| ");
            }
            else{
                System.out.print("  ");
                System.out.print("| ");
            }
        }
        //윗쪽을 선택했다면 o 또는 x
        if (userInput.equals("U")){
            if(userInput.equals(bridge.get(num-1))){
                System.out.print("O ");
            }
            else{System.out.print("X ");}
        }else {
            System.out.print("  ");
        }

        //윗쪽을 선택하지 않았다면 null
        System.out.println("]");
        System.out.print("[ ");
        for(int i=0;i<num-1;i++){
            if (bridge.get(i).equals("D")){
                System.out.print("O ");
                System.out.print("| ");
            }
            else{
                System.out.print("  ");
                System.out.print("| ");
            }
        }
        if (userInput.equals("D")){
            if(userInput.equals(bridge.get(num-1))){
                System.out.print("O ");
            }
            else{System.out.print("X ");}
        }else {
            System.out.print("  ");
        }
        //아랫쪽을 선택했다면 o 또는 x
        //아랫쪽을 선택하지 않았다면 null
        System.out.println("]");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int num, List<String> bridge){
        System.out.println("최종 게임 결과");
        System.out.print("[ ");
        for(int i=0;i<num;i++){//현재까지 결과 출력
            if (bridge.get(i).equals("U")){
                System.out.print("O ");
                if(i!=num-1){
                    System.out.print("| ");
                }
            }
            else{
                System.out.print("  ");
                if(i!=num-1){
                    System.out.print("| ");
                }
            }
        }
        System.out.println("]");

        System.out.print("[ ");
        for(int i=0;i<num;i++){
            if (bridge.get(i).equals("D")){
                System.out.print("O ");
                if(i!=num-1){
                    System.out.print("| ");
                }
            }
            else{
                System.out.print("  ");
                if(i!=num-1){
                    System.out.print("| ");
                }
            }
        }
        System.out.println("]\n");
    }

    /** 게임 시작 문구 출력 */
    public void printStart(){System.out.println(ConstantView.START.getMessage());
    }
    /** 다리 길이 입력 문구 */
    public void gettingLength(){
    System.out.println(ConstantView.SIZE.getMessage());
    }
    /** 이동할 칸 선택 문구 */
    public void printMoving(){
        System.out.println(ConstantView.MOVE.getMessage());
    }
    /** 게임 재시작 여부 확인 문구 출력 */
    public void choiceRestart(){
        System.out.println(ConstantView.END.getMessage());
    }
}
