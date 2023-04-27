public class PaintJob {

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        return ((width <= 0) || (height <= 0) || (areaPerBucket <= 0) || (extraBuckets < 0)) ? -1
                : (int) Math.ceil(((width * height) - (extraBuckets * areaPerBucket)) / areaPerBucket);

//        if((width <= 0) || (height <= 0) || (areaPerBucket <= 0) || (extraBuckets < 0)) return -1;
//
//        double area = 0;
//        area = width * height;
//
//        return  (int) Math.ceil((area - (extraBuckets * areaPerBucket)) / areaPerBucket);
    }


    public static int getBucketCount(double width, double height, double areaPerBucket) {
        return ((width <= 0) || (height <= 0) || (areaPerBucket <= 0)) ? -1
                : (int) Math.ceil((width * height) / areaPerBucket);
    }


    public static int getBucketCount(double area, double areaPerBucket) {
        return ((area <= 0) || (areaPerBucket <= 0)) ? -1
                : (int) Math.ceil(area / areaPerBucket);
    }
}
