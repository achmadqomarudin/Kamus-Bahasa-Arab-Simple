package com.example.achmad.kamusbahasaarab;

import java.util.ArrayList;
import java.util.List;

public class HelperData {

    private static final String create_tb = "CREATE TABLE IF NOT EXISTS employee (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "arb1 VARCHAR(50)," +
            "arb2 VARCHAR(50)," +
            "ind VARCHAR(50))";

    public static final List<String> data = new ArrayList<String>(){{
        add(create_tb);
        add("INSERT INTO employee VALUES(1, 'ائتاب: رجع، عاد', 'اِئْتَابَ: رَجَعَ، عَادَ', 'pulang, kembali' ) ");
        add("INSERT INTO employee VALUES(2, 'ائتزر: لبس الإزار', 'اِئْتَزَرَ: لَبـِسَ الإزَارَ', 'memakai kain (sarung)' ) ");
        add("INSERT INTO employee VALUES(3, 'ائتسى ب: اقتدى ب', 'اِئْتَسَى بـِ: اِقْتَدَى بـِ', 'meniru, mengikuti, mencontoh' )  ");
        add("INSERT INTO employee VALUES(4, 'ائتكل غضبا', 'اِئْتَكَلَ غَضَباً', 'menggelegak (karena muntah)' ) ");
        add("INSERT INTO employee VALUES(5, 'ائتكل: انظر: تآكل', 'اِئْتَكَلَ: اُنْظُرْ: تَآكَلَ', 'membuat korosi, menyala' ) ");
        add("INSERT INTO employee VALUES(6, 'ائتكلت النار', 'اِئْتَكَلَتِ النّارُ', 'menyala (api), berkobar, merah membara' ) ");
        add("INSERT INTO employee VALUES(7, 'ائتلاف (بين أحزاب أو هيئات أو دول)', 'اِئْتِلاف (بَيْنَ أَحْزَابٍ أو هَيْئاتٍ أو دُوَل)', 'organisasi, koalisi (antara partai, negara)' ) ");
        add("INSERT INTO employee VALUES(8, 'ائتلاف: انسجام، وفاق، وئام، اتحاد', 'اِئْتِلاف: اِنْسِجَام، وِفَاق، وِئَام، اِتّحَاد', 'keselarasan, keserasian, kesesuaian' ) ");
        add("INSERT INTO employee VALUES(9, 'ائتلافي', 'اِئْتِلافِيّ', 'tentang hal koalisi' ) ");
        add("INSERT INTO employee VALUES(10, 'ائتلف (مع): تناغم، انسجم', 'اِئْتَلَفَ (مَع): تَنَاغَمَ، اِنْسَجَمَ', 'seimbang, berpadaan, sesuai, cocok' ) ");
        add("INSERT INTO employee VALUES(11, 'ائتلف: اتحد، انضم', 'اِئْتَلَفَ: اِتّحَدَ، اِنْضَمّ', 'menggabungkan, mempersatukan' ) ");
        add("INSERT INTO employee VALUES(12, 'ائتلف: شكل ائتلافا (بين أحزاب إلخ)', 'اِئْتَلَفَ: شَكّلَ ائْتِلافاً (بَيْنَ أَحْزَابٍ إلخ)', 'membuat koalisi (antara partai dll)' ) ");
        add("INSERT INTO employee VALUES(13, 'ائتلق - انظر: تألق', 'اِئْتَلَق - اُنْظُرْ: تألّق', 'bercahaya, bersinar' ) ");
        add("INSERT INTO employee VALUES(14, 'ائتم ب: اقتدى ب', 'اِئْتَمّ بـِ: اِقْتَدَى بـِ', 'meniru, mengikuti, mencontoh' ) ");
        add("INSERT INTO employee VALUES(15, 'ائتم: قصد - انظر: أم', 'اِئْتَمّ: قَصَدَ - اُنْظُرْ: أمّ', 'bermaksud' ) ");
        add("INSERT INTO employee VALUES(16, 'ائتمار: تآمر', 'اِئْتِمَار: تَآمُر', 'kolusi, konspirasi' ) ");
        add("INSERT INTO employee VALUES(17, 'ائتمار: تشاور', 'اِئْتِمَار: تَشَاوُر', 'pertemuan, konsultasi, konperensi' ) ");
        add("INSERT INTO employee VALUES(18, 'ائتمار: طاعة، خضوع', 'اِئْتِمَار: طَاعَة، خُضُوع', 'taat, tunduk, patuh' ) ");
    }};

    public static List<String> getData() {
        return data;
    }

   /* private class ArrayFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();

            if (mOriginalValues == null) {
                synchronized (mLock) {
                    mOriginalValues = new ArrayList<>(mObjects);
                }
            }

            if (prefix == null || prefix.length() == 0) {
                ArrayList<String> list;
                synchronized (mLock) {
                    list = new ArrayList<>(mOriginalValues);
                }
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();
                mSearchText = prefixString;
                ArrayList<String> values;
                synchronized (mLock) {
                    values = new ArrayList<>(mOriginalValues);
                }

                final int count = values.size();
                final ArrayList<String> newValues = new ArrayList<>();

                for (int i = 0; i < count; i++) {
                    final String value = values.get(i);
                    final String valueText = value.toLowerCase();

                    // First match against the whole, non-splitted value
                    if (valueText.startsWith(prefixString)) {
                        newValues.add(value);
                    } else {
                        final String[] words = valueText.split(" ");
                        final int wordCount = words.length;

                        // Start at index 0, in case valueText starts with space(s)
                        for (int k = 0; k < wordCount; k++) {
                            if (words[k].startsWith(prefixString)) {
                                newValues.add(value);
                                break;
                            }
                        }
                    }
                }

                results.values = newValues;
                results.count = newValues.size();
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

        }*/
}
