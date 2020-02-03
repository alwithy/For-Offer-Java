public class Code_055_FirstCharacterInStream {
    //P247, 面试题50 题目二 字符流中第一个只出现一次的字符
    //使用一个数据容器保存字符在字符流中的位置
    static class CharStatistics{
        private int[] occurrence;
        private int index;

        public CharStatistics() {
            occurrence = new int[256];
            for (int i = 0; i < 256; i++) {
                occurrence[i] = -1;
            }
            index = 0;
        }

        public void insert(char ch) {
            if (occurrence[ch] == -1) {
                occurrence[ch] = index;
            } else if (occurrence[ch] >= 0) {
                occurrence[ch] = -2;
            }
            index++;
        }

        public char firstAppearingOnce() {
            char ch = '\0';
            int minIndex = Integer.MAX_VALUE;
            for (int i = 0; i < 256; i++) {
                if (occurrence[i] >= 0 && occurrence[i] < minIndex) {
                    ch = (char) i;
                    minIndex = occurrence[i];
                }
            }
            return ch;
        }
    }
}
