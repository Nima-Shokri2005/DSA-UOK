public class Bits {
    private int num;

    public Bits(int num) {
        this.num = num;
    }

    public String binaryRepresentation() {
        return Integer.toBinaryString(num);
    }

    public void setBitToOneAt(int index) {
        num |= (1 << index);
    }

    public void setBitToZeroAt(int index) {
        num &= ~(1 << index);
    }

    public void toggleBitAt(int index) {
        num ^= (1 << index);
    }

    public int getBitAt(int index) {
        return (num >> index) & 1;
    }
}