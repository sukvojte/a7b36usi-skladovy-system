/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.a7b36usi.sklad.testy;
import cz.a7b36usi.sklad.DTO.ZakaznikDTO;
import cz.a7b36usi.sklad.Service.IUserService;
import cz.a7b36usi.sklad.Service.IZakaznikService;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ZakaznikServiceTest  extends AbstractServiceTest{
    
    @Autowired
    IUserService userService;
    
    @Autowired
    IZakaznikService zakaznikService;
    
    
    @Test
    public void testGetAllZakaznik(){
        boolean isDod=true;
        boolean isOdb=false;
        String street="ULICE";
        String mesto="mesto"+System.currentTimeMillis();
        String spolecnost="BLA BLA"+System.currentTimeMillis();
        int psc=90324;
        int cisloPop=43551553;
        Long id=zakaznikService.addZakaznik(isDod, isOdb, street,mesto ,spolecnost , psc, cisloPop);
         boolean isDod2=false;
        boolean isOdb2=true;
        String street2="ULICE2";
        String mesto2="mesto2"+System.currentTimeMillis();
        String spolecnost2="BLA BLA2"+System.currentTimeMillis();
        int psc2=9056754;
        int cisloPop2=4324578;
        Long id2=zakaznikService.addZakaznik(isDod2, isOdb2, street2,mesto2 ,spolecnost2 , psc2, cisloPop2);
        List<ZakaznikDTO> list=zakaznikService.getAllZakaznik();
        assertFalse(list.isEmpty());
        boolean det1=false;
        boolean det2=false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                ZakaznikDTO zak1=list.get(i);
                assertNotNull(zak1);
                assertEquals(isDod,zak1.isIsDodavatel());
                assertEquals(isOdb,zak1.isIsOdberatel());
                assertEquals(street,zak1.getUlice());
                assertEquals(mesto, zak1.getMesto());
                assertEquals(spolecnost,zak1.getSpolecnost());
                assertEquals(psc,zak1.getPsc());
                assertEquals(cisloPop,zak1.getCisloPopisne());
                det1=true;
            }else if(list.get(i).getId().equals(id2)){
                ZakaznikDTO zak1=list.get(i);
                assertNotNull(zak1);
                assertEquals(isDod2,zak1.isIsDodavatel());
                assertEquals(isOdb2,zak1.isIsOdberatel());
                assertEquals(street2,zak1.getUlice());
                assertEquals(mesto2, zak1.getMesto());
                assertEquals(spolecnost2,zak1.getSpolecnost());
                assertEquals(psc2,zak1.getPsc());
                assertEquals(cisloPop2,zak1.getCisloPopisne());
                det2=true;
            }
            
        }
        assertTrue(det1);
        assertTrue(det2);
    }
    
    @Test
    public void testAddZakaznik(){
        boolean isDod=true;
        boolean isOdb=false;
        String street="ULICE";
        String mesto="mesto"+System.currentTimeMillis();
        String spolecnost="BLA BLA"+System.currentTimeMillis();
        int psc=90324;
        int cisloPop=43551553;
        Long id=zakaznikService.addZakaznik(isDod, isOdb, street,mesto ,spolecnost , psc, cisloPop);
        List<ZakaznikDTO> zak = zakaznikService.getAllZakaznik();
        assertNotNull(zak);
        assertTrue(!zak.isEmpty());
        ZakaznikDTO zak1=null;
        for (int i = 0; i < zak.size(); i++) {
            if(zak.get(i).getId()==id) zak1=zak.get(i);
            
        }
        assertNotNull(zak1);
        assertEquals(isDod,zak1.isIsDodavatel());
        assertEquals(isOdb,zak1.isIsOdberatel());
        assertEquals(street,zak1.getUlice());
        assertEquals(mesto, zak1.getMesto());
        assertEquals(spolecnost,zak1.getSpolecnost());
        assertEquals(psc,zak1.getPsc());
        assertEquals(cisloPop,zak1.getCisloPopisne());
    }
    
    @Test
    public void testSaveZakaznik(){
         boolean isDod=true;
        boolean isOdb=false;
        String street="ULICE";
        String mesto="mesto"+System.currentTimeMillis();
        String spolecnost="BLA BLA"+System.currentTimeMillis();
        int psc=90324;
        int cisloPop=43551553;
        Long id=zakaznikService.addZakaznik(isDod, isOdb, street,mesto ,spolecnost , psc, cisloPop);
        List<ZakaznikDTO> zak = zakaznikService.getAllZakaznik();
        assertNotNull(zak);
        assertTrue(!zak.isEmpty());
        ZakaznikDTO zak1=null;
        for (int i = 0; i < zak.size(); i++) {
            if(zak.get(i).getId()==id) zak1=zak.get(i);
            
        }
        assertNotNull(zak1);
        assertEquals(isDod,zak1.isIsDodavatel());
        assertEquals(isOdb,zak1.isIsOdberatel());
        assertEquals(street,zak1.getUlice());
        assertEquals(mesto, zak1.getMesto());
        assertEquals(spolecnost,zak1.getSpolecnost());
        assertEquals(psc,zak1.getPsc());
        assertEquals(cisloPop,zak1.getCisloPopisne());
    }
    
    @Test
    public void removeZakaznik(){
        boolean isDod=true;
        boolean isOdb=false;
        String street="ULICE";
        String mesto="mesto"+System.currentTimeMillis();
        String spolecnost="BLA BLA"+System.currentTimeMillis();
        int psc=90324;
        int cisloPop=43551553;
        Long id=zakaznikService.addZakaznik(isDod, isOdb, street,mesto ,spolecnost , psc, cisloPop);
        
        List<ZakaznikDTO> zak = zakaznikService.getAllZakaznik();
        ZakaznikDTO zak1=null;
        for (int i = 0; i < zak.size(); i++) {
            if(zak.get(i).getId()==id) zak1=zak.get(i);
            
        }
        zakaznikService.removeZakaznik(zak1);
        zak = zakaznikService.getAllZakaznik();
        zak1=null;
        for (int i = 0; i < zak.size(); i++) {
            if(zak.get(i).getId()==id) zak1=zak.get(i);
            
        }
        assertNull(zak1);
    }
}
