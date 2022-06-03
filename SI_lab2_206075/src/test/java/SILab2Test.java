
import  java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jdk.jshell.spi.ExecutionControl;
import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private List<String> createList(String... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }
    @Test
    void everyStatementTest(){
        List<String> nullt=createList();
        IllegalArgumentException ex;
        ex=  assertThrows(IllegalArgumentException.class,()-> SILab2.function(nullt));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));
        List<String> list1 = createList("#","0","0");
        ex = assertThrows(IllegalArgumentException.class,() ->SILab2.function((list1)));
        assertTrue(ex.getMessage().contains("List length should be a perfect square"));
        List<String> list2 = createList("1","#","2","#","0","#","4","#","2");
        assertEquals(list2,SILab2.function((createList("0","#","0","#","0","#","0","#","0"))));
    }
    @Test
    void everyBranchTest() {
        List<String> nullb=createList();
        RuntimeException ex;
        ex=  assertThrows(RuntimeException.class,()-> SILab2.function(nullb));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));
        List<String> list3 = createList("#","0","0");
        ex = assertThrows(RuntimeException.class,() ->SILab2.function((list3)));
        assertTrue(ex.getMessage().contains("List length should be a perfect square"));
        List<String> list4 = createList("1","#","0","1", "2","#","#","0","#");
        assertEquals(list4,SILab2.function((createList("1", "0 " ,"#" , "#" ,"0" ,"0" ,"1", "2" ,"#"))));
        List<String> list5 = createList("1","#","2","#","0","#","4","#","2");
        assertEquals(list5,SILab2.function((createList("0","#","0","#","0","#","0","#","0"))));


    }