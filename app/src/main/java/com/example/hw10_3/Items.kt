package com.example.hw10_3

import androidx.core.content.res.TypedArrayUtils.getString


data class Items(var id:Int,var pictureId:Int,var title:String,var description:String) {

}

object Storage{
    var editFlag=false
    var indexOfDetail=0
    //var item=4
    var arrayOfItems=arrayOf(
        Items(1,R.drawable.m1,"طبیعت 1", "طبیعت هنگامی زیبا است که در ما همان تأثیر هنر را نداشته باشد،.\n" +
                "به این طریق، زیبائی چه در طبیعت و چه در هنر ممکن است.\n" +
                "به وسیله همآهنگی و شورانگیزی و مخصوصأ اتحاد درونی آن دو باهم، توصیف گردد. "),

        Items(2,R.drawable.m2,"طبیعت 2", "آن\u200Cجا که طبیعت توقف می\u200Cکند، هنر آغاز می\u200Cشود. آن\u200C که انتظار دارد هر چهار فصل سال بهار باشد، نه خود را می\u200Cشناسد، نه طبیعت را و نه زندگی را.\n" +
                "طبیعت مهربان ترین دوست ما و بهترین منتقد علم تجربی است، اگر تنها اجازه دهیم اطلاعیه هایش بی طرفانه وارد ذهنمان شود."),

        Items(3,R.drawable.m3,"طبیعت 3", "با همان شفافیت رنگ و بی خیالی طرح؟\n" +
                "آیا می توان در هنر، طبیعتی دیگر آفرید؟\n" +
                "که با همان قوانین طبیعت الهی شکل گیرد؟\n" +
                "آیا می توان خط مشیت الهی را در طبیعت یافت و درهنر دنبال کرد؟\n" +
                "و دانست که هر چه آن خسرو کند شیرین بود؟\n" +
                "آیا می توان شعری به زیبایی یک درخت گفت؟\n" +
                "و نقشی به زیبایی یک سنجاب کشید؟"),

        Items(4,R.drawable.m4,"طبیعت 4", "با قلم موی باد و باران.\n" +
                "و جنبش خاک و گردش افلاک.\n" +
                "هر دم هزاران نقش بر بوم زمین و آسمان می آفریند.\n" +
                "که مدرنترین آبستره کاران یا انتزاع گرایان جهان در آن حیران می شوند"),

        Items(5,R.drawable.m5,"طبیعت 5",".کدام نظم و هماهنگی مرموز و پنهان\n" +
                "منحنی ابرها و نیمرخ پردندانه کوهها.\n" +
                "و رقص گستاخ و بی خیال امواج را زیبایی بخشیده است.\n" +
                "چه نظامی بر بی نظمی کوه ،ابر و دریا فرمان می راند.\n" +
                "که هزار نقاش را در سلسله گیسوی پریشان خود اسیر کرده است.\n" +
                "آیا می توان آنچه را باد بر بوم کویر نقش می کند"),

        Items(6,R.drawable.m6,"طبیعت 6", "رنگ آبی رنگ خاکی را در آغوش می گیرد.\n" +
                "چنانکه آسمان زمین را.\n" +
                "و از این پیوند ،درخت و سبزه و گل و گیاه و دریاچه و جویبار پدید می آید.\n" +
                "نقاش همچون باد بر رنگ های گزیده خویش می وزد.\n" +
                "و از این وزش بر دریای کوچک رنگ ، موج ها و حباب ها پدید می آید.\n" +
                "و دشت و صحرا و برف و بوران و طوفان نقش می شود"))
}