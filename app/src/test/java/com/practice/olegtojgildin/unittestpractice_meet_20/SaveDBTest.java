package com.practice.olegtojgildin.unittestpractice_meet_20;

import com.practice.olegtojgildin.unittestpractice_meet_20.db.DBManager;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by olegtojgildin on 23/02/2019.
 */

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class SaveDBTest {
    private  DBManager dbManager;

    @Before
    public  void setDbManager(){
        dbManager=DBManager.getInstance(RuntimeEnvironment.application);
    }

    @Test
    public void testCorrectSaveInDb() {
        int res=9;
        dbManager.saveResult(res);
        int actualResult = dbManager.getResult();
        assertEquals(res, actualResult);
    }
    @Test
    public void testInCorrectSaveInDb() {
        int res=9;
        dbManager.saveResult(res);
        int actualResult = dbManager.getResult();
        assertNotEquals(8, actualResult);
    }
}
