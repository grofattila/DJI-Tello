package hu.atig.dji.tello.model.drone;

/**
 * Represents the Tello Drone.
 */
public class TelloDrone implements Drone {

  /*
   * Connection IP address.
   */
  public static final String DRONE_IP_ADDRESS = "192.168.10.1";

  /*
   * Listen IP address.
   */
  public static final String DRONE_LISTEN_IP_ADDRESS = "0.0.0.0";

  /*
   * Send command and receive response udp port.
   */
  public static final Integer UDP_PORT_SEND_COMMAND_RECEIVE_RESPONSE = 8889;

  /*
   * Receive drone state udp port.
   */
  public static final Integer UDP_PORT_RECEIVE_DRONE_STATE = 8890;

  /*
   * Send command and receive response udp port.
   */
  public static final Integer UDP_PORT_RECEIVE_DRONE_VIDEO_STREAM = 11111;

  /**
   * Speed of the drone.
   */
  private Double speed;

  /**
   * Battery percentage of the drone.
   */
  private Integer battery;

  /**
   * Current fly time (seconds).
   */
  private Integer flyTime;

  /**
   * Current fly height (dm).
   */
  private Integer height;

  /**
   * Current temperature of the drone.
   */
  private String temperature;
  private Integer attitudePitch;
  private Integer attitudeRoll;
  private Integer attitudeYaw;
  private Double barometer;
  private Double accX;
  private Double accY;
  private Double accZ;
  private Integer tof;

  private TelloConnection telloConnection;
  private TelloMode telloMode;

  public TelloDrone() {
    telloConnection = TelloConnection.CONNECTED;
    telloMode = TelloMode.NORMAL;
  }

  public Double getSpeed() {
    return speed;
  }

  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  public void setSpeed(String speed) {
    this.speed = Double.valueOf(speed);
  }

  public Integer getBattery() {
    return battery;
  }

  public void setBattery(Integer battery) {
    this.battery = battery;
  }

  public void setBattery(String battery) {
    this.battery = Integer.valueOf(battery.trim());
  }


  public Integer getFlyTime() {
    return flyTime;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = Integer.valueOf(height.split("dm")[0]);
  }


  public void setHeight(Integer height) {
    this.height = height;
  }

  public void setFlyTime(String flyTime) {
    this.flyTime = Integer.valueOf(flyTime.split("s")[0]);
  }

  public void setFlyTime(Integer flyTime) {
    this.flyTime = flyTime;
  }

  /**
   * Sets the attitude values from the drones output.
   *
   * @param attitude Attitude in 3 dimensions.
   */
  public void setAttitude(String attitude) {
    String[] strings = attitude.split(";");
    this.attitudePitch = Integer.valueOf(strings[0].split(":")[1]);
    this.attitudeRoll = Integer.valueOf(strings[1].split(":")[1]);
    this.attitudeYaw = Integer.valueOf(strings[2].split(":")[1]);
  }

  public Integer getAttitudePitch() {
    return attitudePitch;
  }

  public void setAttitudePitch(Integer attitudePitch) {
    this.attitudePitch = attitudePitch;
  }

  public Integer getAttitudeRoll() {
    return attitudeRoll;
  }

  public void setAttitudeRoll(Integer attitudeRoll) {
    this.attitudeRoll = attitudeRoll;
  }

  public Integer getAttitudeYaw() {
    return attitudeYaw;
  }

  public void setAttitudeYaw(Integer attitudeYaw) {
    this.attitudeYaw = attitudeYaw;
  }

  public Double getBarometer() {
    return barometer;
  }

  public void setBarometer(String baro) {
    this.barometer = Double.valueOf(baro);
  }


  public void setBarometer(Double barometer) {
    this.barometer = barometer;
  }

  /**
   * Sets acc form the drones acc data.
   *
   * @param acc Acceleration in 3 dimensions.
   */
  public void setAcc(String acc) {
    String[] strings = acc.split(";");
    this.accX = Double.valueOf(strings[0].split(":")[1]);
    this.accY = Double.valueOf(strings[1].split(":")[1]);
    this.accZ = Double.valueOf(strings[2].split(":")[1]);
  }

  public Double getAccX() {
    return accX;
  }

  public void setAccX(Double accX) {
    this.accX = accX;
  }

  public Double getAccY() {
    return accY;
  }

  public void setAccY(Double accY) {
    this.accY = accY;
  }

  public Double getAccZ() {
    return accZ;
  }

  public void setAccZ(Double accZ) {
    this.accZ = accZ;
  }

  public String getTemperature() {
    return temperature;
  }

  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }

  public TelloConnection getTelloConnection() {
    return telloConnection;
  }

  public void setTelloConnection(TelloConnection telloConnection) {
    this.telloConnection = telloConnection;
  }

  public TelloMode getTelloMode() {
    return telloMode;
  }

  public void setTelloMode(TelloMode telloMode) {
    this.telloMode = telloMode;
  }

  public Integer getTof() {
    return tof;
  }

  public void setTof(String tof) {
    this.tof = Integer.valueOf(tof.split("mm")[0]);
  }

  public void setTof(Integer tof) {
    this.tof = tof;
  }

  @Override
  public String toString() {
    return "TelloDrone  {"
        + "speed=" + speed
        + ", battery=" + battery
        + ", flyTime=" + flyTime
        + ", height=" + height
        + ", temperature='" + temperature + '\''
        + ", attitudePitch=" + attitudePitch
        + ", attitudeRoll=" + attitudeRoll
        + ", attitudeYaw=" + attitudeYaw
        + ", barometer=" + barometer
        + ", accX=" + accX
        + ", accY=" + accY
        + ", accZ=" + accZ
        + ", tof=" + tof
        + ", telloConnection=" + telloConnection
        + ", telloMode=" + telloMode
        + '}';
  }
}
