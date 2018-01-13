package dev.trainingapp.other.enums;

import dev.trainingapp.other.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

public class ConstApp {

    @AllArgsConstructor
    @Getter
    public enum MemberRank {
        FREE("FREE"),
        NORMAL("NORMAL"),
        PREMIUM("PREMIUM");

        private String code;

        public static MemberRank getMemberRank(String code) {
            return Arrays.stream(values())
                    .filter(e -> e.getCode().equals(code))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("不正な会員コードです。 " + code));
        }

    }


    @AllArgsConstructor
    @Getter
    public enum State {
        HOKKAIDOU(1, "北海道", "ホッカイドウ"),
        AOMORI(2, "青森県", "アオモリケン"),
        IWATE(3, "岩手県", "イワテケン"),
        MIYAGI(4, "宮城県", "ミヤギケン"),
        AKITA(5, "秋田県", "アキタケン"),
        YAMAGATA(6, "山形県", "ヤマガタケン"),
        HUKUSHIMA(7, "福島県", "フクシマケン"),
        IBARAGI(8, "茨城県", "イバラキケン"),
        TOTCHIGI(9, "栃木県", "トチギケン"),
        GUNMA(10, "群馬県", "グンマケン"),
        SAITHAMA(11, "埼玉県", "サイタマケン"),
        THIBA(12, "千葉県", "チバケン"),
        TOUKYO(13, "東京都", "トウキョウト"),
        KANAGAWA(14, "神奈川県", "カナガワケン"),
        NIIGATA(15, "新潟県", "ニイガタケン"),
        TOYAMA(16, "富山県", "トヤマケン"),
        ISHIKAWA(17, "石川県", "イシカワケン"),
        HUKUI(18, "福井県", "フクイケン"),
        YAMANASHI(19, "山梨県", "ヤマナシケン"),
        NAGANO(20, "長野県", "ナガノケン"),
        GIHU(21, "岐阜県", "ギフケン"),
        SHIZUOKA(22, "静岡県", "シズオカケン"),
        AITCHI(23, "愛知県", "アイチケン"),
        MIE(24, "三重県", "ミエケン"),
        SHIGA(25, "滋賀県", "シガケン"),
        KYOTO(26, "京都府", "キョウトフ"),
        OOSAKA(27, "大阪府", "オオサカフ"),
        HYOUGO(28, "兵庫県", "ヒョウゴケン"),
        NARA(29, "奈良県", "ナラケン"),
        WAKAYAMA(30, "和歌山県", "ワカヤマケン"),
        TOTTORI(31, "鳥取県", "トットリケン"),
        SHIMANE(32, "島根県", "シマネケン"),
        OKAYAMA(33, "岡山県", "オカヤマケン"),
        HIROSHIMA(34, "広島県", "ヒロシマケン"),
        YAMAGUTHI(35, "山口県", "ヤマグチケン"),
        TOKUSIMA(36, "徳島県", "トクシマケン"),
        KAGAWA(37, "香川県", "カガワケン"),
        EHIME(38, "愛媛県", "エヒメケン"),
        KOUTHI(39, "高知県", "コウチケン"),
        HUKUOKA(40, "福岡県", "フクオカケン"),
        SAGA(41, "佐賀県", "サガケン"),
        NAGASAKI(42, "長崎県", "ナガサキケン"),
        KUMAMOTO(43, "熊本県", "クマモトケン"),
        OOITA(44, "大分県", "オオイタケン"),
        MIYAZAKI(45, "宮崎県", "ミヤザキケン"),
        KAGOSHIMA(46, "鹿児島県", "カゴシマケン"),
        OKINAWA(47, "沖縄県", "オキナワケン");

        private Integer prefectureCd;
        private String name;
        private String kana;

        public static Optional<State> getOpt(Integer prefectureCd) {
            return Arrays.stream(values())
                    .filter(e -> e.getPrefectureCd() == prefectureCd)
                    .findFirst();
        }

        public static State getState(Integer prefectureCd) {
            return Arrays.stream(values())
                    .filter(e -> e.getPrefectureCd() == prefectureCd)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("不正な都道府県コードです。 " + prefectureCd));
        }
    }

}
