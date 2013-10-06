package money.sac.dev.Helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import money.sac.dev.Model.BankAccountMonth;

/**
 * Created by Kev1n on 06.10.13.
 */
public class LocalPersistence {
    /**
     *
     * @param context
     * @param object
     * @param filename
     */
    public static void witeObjectToFile(Context context, BankAccountMonth object, String filename) {

        ObjectOutputStream objectOut = null;
        try {

            FileOutputStream fileOut = context.openFileOutput(filename, Activity.MODE_PRIVATE);
            objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(object);
            fileOut.getFD().sync();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOut != null) {
                try {
                    objectOut.close();
                } catch (IOException e) {
                    // do nowt
                }
            }
        }
    }


    /**
     *
     * @param context
     * @param filename
     * @return
     */
    public static BankAccountMonth readObjectFromFile(Context context, String filename) {

        ObjectInputStream objectIn = null;
        BankAccountMonth object = null;
        try {

            FileInputStream fileIn = context.getApplicationContext().openFileInput(filename);

            objectIn = new ObjectInputStream(fileIn);
            object = (BankAccountMonth)objectIn.readObject();

        } catch (FileNotFoundException e) {
            // Do nothing
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectIn != null) {
                try {
                    objectIn.close();
                } catch (IOException e) {
                    // do nowt
                }
            }
        }

        return object;
    }

    public static List<String> getAllFilesNames(Context context){
        return new LinkedList<String>(Arrays.asList(context.getApplicationContext().fileList()));
    }
}
