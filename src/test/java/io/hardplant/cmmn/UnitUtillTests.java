package io.hardplant.cmmn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.hardplant.cmmn.impl.UnitUtills;

public class UnitUtillTests {
    @Test
    public void Test_UnitName1() {
        assertEquals("illumi",UnitUtills.getUnitByName("櫻木真乃"));
    }
    @Test    
    public void Test_UnitName2() {
        assertEquals("antica",UnitUtills.getUnitByName("月岡恋鐘"));
    }
    @Test
    public void Test_UnitName3() {
        assertEquals("afterschool",UnitUtills.getUnitByName("小宮果穂"));
    }
    @Test
    public void Test_UnitName4() {
        assertEquals("alstromeria",UnitUtills.getUnitByName("大崎甘奈"));
    }
    @Test
    public void Test_UnitName5() {
        assertEquals("straylight",UnitUtills.getUnitByName("芹沢あさひ"));
    }
    @Test
    public void Test_UnitName6() {
        assertEquals("noctchill",UnitUtills.getUnitByName("浅倉透"));
        assertEquals("noctchill",UnitUtills.getUnitByName("市川雛菜"));
    }
}