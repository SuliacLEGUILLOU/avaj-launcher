
public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        if (height > 100) {
            this.height = 100;
        } else if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }

    public int getLongitude() {
        return longitude;
    }
    public int getLatitude() {
        return latitude;
    }
    public int getHeight() {
        return height;
    }

    /**
     * Update Coordinate
     * @param value : Int use to change coordinate
     * @return Boolean : tells if a boundary have been met
     */
    public boolean updateLongitude(int value) {
        this.longitude += value;
        if (this.longitude >= 20000 || this.longitude <= 0) {
            if (this.longitude >= 20000) {
                this.longitude -= 20000;
            } else {
                this.longitude += 20000;
            }
            return true;
        }
        return false;
    }
    public boolean updateLatitude(int value) {
        this.latitude += value;

        if (this.latitude >= 20000 || this.latitude <= 0) {
            if (this.latitude >= 20000) {
                this.latitude -= 20000;
            } else {
                this.latitude += 20000;
            }
            return true;
        }
        return false;
    }
    public boolean updateHeight(int value) {
        this.height += value;

        if (this.height > 100) {
            this.height = 100;
        } else if (this.height <= 0) {
            this.height = 0;
            return true;
        }
        return false;
    }
}
