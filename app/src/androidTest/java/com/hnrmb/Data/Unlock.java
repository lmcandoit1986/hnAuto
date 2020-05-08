package com.hnrmb.Data;

import android.graphics.Point;

public class Unlock {

    public static Point[] getLockTrail(int X, int Y){

        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        p1.x =293;
        p1.y =915;
        p2.x =819;
        p2.y =915;
        p3.x =819;
        p3.y =1457;
        Point[] points_1920_1080={p1,p2,p3};

        if(X ==1080 && Y==1920){
            return points_1920_1080;
        }else{
            return points_1920_1080;
        }

    }

}
