public class SheetCommonCommuTableConverterTest {

    @Test
    public void testConvert() {
        SheetCommonCommuConverter converter = new SheetCommonCommuConverter();

        List<List<Object>> datas = new DataSheetDAO().getMorningDatas("마노_P");
        
        List<MorningSelectionTable> tables = converter.sheetToMorningTables(datas);

        assertEquals(9, tables.size());
    }
}