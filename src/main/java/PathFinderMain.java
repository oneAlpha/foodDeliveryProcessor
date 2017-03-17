import Core.BestPathFinder;
import Core.OrderAllocator;
import Entity.*;
import application.PathFinderApplication;
import javafx.util.Pair;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bibek on 11/03/17.
 */
public class PathFinderMain {

    public static void main(String [] args){

        PathFinderApplication application = PathFinderApplication.getInstance();
        // Run order mapping
        application.runSampleOrderMapping();

        // Run path finder
        application.runBestPathFinderTest();

        return;
    }
}
