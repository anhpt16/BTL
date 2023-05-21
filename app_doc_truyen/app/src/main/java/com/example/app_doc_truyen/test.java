package com.example.app_doc_truyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_doc_truyen.common.common;
import com.example.app_doc_truyen.model.PhanLoai;
import com.example.app_doc_truyen.model.Tap;
import com.example.app_doc_truyen.model.Truyen;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class test extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("PhanLoai");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        EditText img = findViewById(R.id.image);
        EditText Name = findViewById(R.id.name);
        Button btnluu = findViewById(R.id.luu);
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mảng tập
                List<Tap> taps = new ArrayList<>();
                //tên tập
                String Ten = "Tôi yêu cậu, còn cậu";
                //mảng link image
                List<String> linkss = new ArrayList<>();
                linkss.add("https://cdn-4.ohay.tv/imgs/f3d3c1a2751e4c10824e/728.jpg");
                linkss.add("https://lh3.googleusercontent.com/OLNxZO_CG_-dPhrdMk9xkcenN2zCIO30V_yXm_BUoXsMP9_pox0FNrHAOEWFcnqryMYADf4NKISgIyxnAJjn6DD8hxVg5cjAir1bl5NymzNAZ88H1setrfmR8Dq3PneJMf77gzlzY6PvbL7FASgX6KX3TeW1LZPVaJWmecYzDJsMnjQL7FdoQE-qDtuGz-o9Aai-8OOIwuVEntjIL4p1xg0lxk91QABZv5NopUZeBI_XP8BV8mE0vKz9fGgjJz3563Msf1_mcVvpC9tYIQYNLLI6rlhaQRNtmm0lqA7GDir5kSYqS4EHjU9EYD-F3nYHxTz1MujAOKXpLmjZxND_jBBZtAtXrOaC8W74Y-FbPLjTSxWaZeoX2w4_TKMcwW1HR1fGGCTZWf9jPajABeM32JxQtC6jc8N8OLkmCZN4MIbrVCo2sPyQHmMWXrlfd9I8SGIqHDdzjM0Zdc41GlpCRBBXci4pOOj7MqPcK0Dr3yNxzDAiHlaFuDoYikkMoL7sm4CbO_8S3RFeGbRJRhFt_LTEdqUkNzK76LDuICYtBhEN3CGEOfl3b2--m3Yer52IbgrlTjgqxEcd_oUiTcwYZyVkLHg7IlJxeP8jov07sxmgVMRDUpcoQh13kRMQIC1RLrGszu-Ew8iw55fW6-RCN5m35eaMc45qup5Uuttlg6KU5TmxtxAZdJEcjwseg3k85KBMDWe5_xkQlMjT1cdg4jDTwqFA-zF0BhG156P0RbuX9_zEXdkTlFQeHMjbH5Q8V90ya90l4BtyAao4-yOIH7WK1zcquDlxDfS3R66-1rNoOHfgaj3_LC_QTX27PN5ABfwY3F7olTR0WS8kkORm1eSCHuKTcLNaBRBJCnHACY1yT62OjimFSVLz11VBGVSU2h-O0fw61gen4_FqnZbHNpoMM6uQgJXFXSh7X_wPrDg=w602-h758-no?authuser=0");
                linkss.add("https://lh3.googleusercontent.com/II7VLKIw5c9GI9Pp4koeegK0tVkdfnxVm1oa88Tdlt_S8OnDvwH4UpxhLJbaE5kTLtQ16lM5IlhkHrJeUhzY4FvzC_h1U3JMzEYck-Qy_PWd4iCHjJb6i_H8AQuIztvDC6r4-hpvfvw85hrZO6GHr59m3D-YRNItWf42CMkszfvMkFiXzE6G6GYhBsdyVKm4z1obx0IC1FtZnmlWfG4WG3X9lNHzWZaQOtsN1TK-RJL2B0jZK6mlHlBcq7cOvoJaJCVO67GKo23bBd-CNX4elMYxiT8zL6Gp34MdLKOfu0bv9SYOQrdyQElZWVVz_xQ7LIhz489Q9egIwxpLxN7t75u4CNX8gJ0Uq_iRWMDW8p56jdXHx6UR0kENOUZncvi9zTqN0Tz6OG7uvzGpGJpHSHevL47BHoqTNoD8yyX0vHvU152vhR8Ugr2HOe1by8Mf0UQ1mjvgYaJUbwSizeXe_fQAsbnQKT8qkGiqzLTLo357Ms20kU8DVt9cZOSJqKaH3FCXUTPpVDkRsGpoBB3TAgKXTcHN53VYBHzFV6vim6ryH6SFFX7iT2mECkf4DjlW3Ga_qZZvIn5TwaweSFHHBquZrnX8z_QY-33j_Brw0NDNyRTjOI-m39YdUmqrhKXHVNSeXW9tpAPWXy9X1VOoOIt3uzJ3nxuq75UAe87uW41tjt1Er16PdIUkviRFwYfakc8OIVPP8bCbYtL3z9hmjj4xOsEm39lhXSgEIQMx4pki5MK85Glm93OiSc6b2V6ftRWc9JlvmKFqRPAwXzTCMWSs4pdJD9BphP3jlZgJfScXVIQAq03yirJ84CfQL8SHLVwAMyNibQOoksfOAladJniDuagnsDYHE2p5KHDEyXWiH9lZA48dNVGjQVr5KLGSBZfSd2HTwRahnJgHPN9EPuq23kqF8XbstSPpw87jzHM=w608-h762-no?authuser=0");
                linkss.add("https://lh3.googleusercontent.com/8s-2MlXzq2ZHDCEMg4ZzvhX7oA0UV1aI8_vbOwbfA2Yg2Khbr_oRv33r_rzBu9o07V2azGlxQ_OZw3Kiht3ypOAo6Cv8yGRgO9l81Pw79AtR-MED4GKrh8r3WKVSSkV3KdLtqKvkJdaz2EIhHNteBRwhec8dXUbI6wMppHNTFifnb0stm_CJDt68fpRj1RaBAj-ImQDqFYirC0cCJydiXjVOzVk364rDWk0k1GwAy__AZ8tgial5Nw84c6SYsVzN-3HP0t2Pd-nx2iLUwLBMVUJY0h0sYQ2h77ADKS5jPYXrLIimOe-D2CxKuZ7h1B1oONm9unAcMSQ7P-HtC3hM-5LDL11AIZ5StjGefplnnYa-MMiHy5Gs9fO3Dz_slgDwSsi00C-kx09Va6YrgW_VuzUV1MgyRah9f7NXlL0km4YpoCgMVyUwx28KC8kPLmjSC3rrNx552eJLUOr2LgBVaJk6qLuuAVI3DIGyJ_hGS7welRZci_T4dNywFsGnUNVAUE-9g9XIkUaW-w8Cbwk1yghx89zhRZ1UUuq6O1TQTSVKfc4CsV1LDdicC4m8bkkLzjdT-hVbkAKIoeajIMvltmEjOz4a1Ybz5QdL2AuUB4V6XcsPeLJVjIq5T5FvE5vTaCCjm4MYCZ__7S9iGw7RXPUv6AT_7ooErG6A0cwZOe2dWTcatJEcbrbTN_0cKTaKAKGJzyHCZPESIbnmDh4eD2HexfLvbP_DjUtE8PCZ_rcnDLezxWxJ153AjOz_vTL_KRdUv3hy6mBfNDAemtqTRzcsbyfPuwNCdAZdCIQgPlH0iuBgrK7a-TgQiJgvMhiEsbWfzIvktz4koeVQ339xUhyrvXdtKH9i8So5udBnp6M_dHkNKm0ZCUPv9_jV4NUP1xmNY5vAnmEBuKHdB8n2PT6uzmdV4Ycz6H6P7Qb5lOI=w602-h758-no?authuser=0");
                linkss.add("https://lh3.googleusercontent.com/wU13YN1fQHTpaVolZYXBPaqnqo49VrqRIrmmbqRS6IRXjATqb2vwVxY7oFACvHBW81jTQS8Ax1-7y5as8d-JZfRkquG0OuHW_3-DxqdYBa7eOTp_vD4OuU3fvCdF986GD6WECiR5nFOQVWZeIdJ71eg3ULay3hqP2vUqAN8tavY8pFE4R9SAk3KCu1TXk5K7j7sRmzF486XXGWu-gPV5dl739UuR2oTLolRxD61Ffq7t02wB-hQPD0InalKvle_sNH9zjkyb9KSIH8rBeP0v0prlsETVqP58kBjVvgcyWRBreWLSscmglxzAWD5C8IB3ePBIzNrBWEYwY85qMUtIoxbSBdXPmMbZF7azwmwxSx-Ku7ozD8jdeiZEhmhfDWNG5HUeJxDu_k-GAzVEInRoNMBjuu2xfYF5EI41SvlAQpI8dSgetru_QA2c40kkh3uPsuo1G7-RHhStQxlVDWM0-rzggRTQMs0S-dAgh-ERjwqQUI4XYP3ywKeIQKwxCGAHFIaXLfS825pD_eaxyUk1IUSqRPmwl6XjfJ4xVp2oEF7lPu5zib3B_4rTW1l9CJ09AKLrcgA7dkZN8dqHnvum9DqDmWdpzsydXRITxMbJAiVirEgHNQBBfx2mbObtD-sw2w4NZUEICHRu2QrB1dDSvAADAMO0uW57Rh9mo1mvDF5lPz_YU1WafXaoKMCJKlNDy7gZzNemLcdIsG1S2LpSPNd39pk0o5r71rRWtkSNMxQuUfSaH9zF-yzRr5UmDLlCBK7x-hlBAjTQ6aVniTlJj3hPwoZroZHSIFUYmh2BLAU8pmf6mjm3KCUGGkCNT06P60ZW2KFkkun7g0X4QGIFDS8yDp3xjxDxgKSiycQlrTXNT1UaEFSN9qu0isByzWaXo2Y1Q7l_u7I7kLJGpTWjt32cfo1gF3sFGpqPMarF0Ik=w599-h764-no?authuser=0");
                linkss.add("https://lh3.googleusercontent.com/xOyikxT2QieqQC99ssxmfTIF8eoF7R8120XOMLInNyDYqNH9BBk3jxHNg4Cc6-WnHi1c1qw6a8kkpWgsntT3q0tjPypt6yRjDImfABppSIQGiOgRBbMcX7uHx2hyq0TaEItFNa4LxX2VTGghua5Xkr9TNZy7MriT6jgK05caNf9Ux8Z7ZhmdExKf3BQs20fujCxi4PFM4qLO-6UeYNTwR6VqsTFJAtjqVzNjngPIAH_YwmYozy6fDKvkjoiB6dMx-a8MEMCeycUGvMOBuBsC-D1IrGeuN-ED7f-0OvPyYtuWvbg10NNXqBSkVnMoDyFlrksy-KZelYICWe0MZfG7RcMcYr4FPjOLoQ9BVmveADJwaBa4PlcyK0VaK3pVSwk27bOMaeuDiDEOYfEImhR1VpKlseI9ijkrb7sKYwpweev84_P0ZlGYVvKGILRe8RQRel90dlj24buMmjkqdIxmDGIHIuNV3tYJb2Kk-IkQrUbX3osrskdw0dvueNTkwwXL6nWuw_sktFm-1BImsJTz_WLvE3QlLVuJyy5fwe6prqMKrMrgYH2gbwX8S9PUSvqaqX59-hadfqsq-t4tvWUhfaNVuqG_qqKUW4AI7NBvt5gtlSY8Ye7fw-1ZV6j94MNmfaDA5WBgRjw4wuDDMywyYwIdJRbLUuO-5dQQ98Gybf_Jjn51YYIskvaUZZme2AyaA3r6pNCgvgEFx2WAm3k3vTFR5g-tP0iEbGhSlq8_qAzsnfFJ75qrYf1ig766-LBi0HJSTWsNpaDHUoOU-js6RkoUz0v-W6W1dqMj6_qjwrzzMA3riFNFZ5xVnNmKnloINQcUYpPd6E9PpWavDNqC_YyCHhsoY3LuB9gwOCjYkGk6lwINkKTY1AU9Z57JHEnQMRyxgP39AWg6JQFJyxQdCtSQZvuKqiFoRflwyeCLwqQ=w600-h756-no?authuser=0");
                linkss.add("https://lh3.googleusercontent.com/xiAHntwLUtBIv9gT5L4H_X__qvoVSF-dj8McAtRAKPUclwlDfyP3iUJcwTopE8FvFaSgNFvug_sp9Ti3mM6mXthWtdlQalaDLpVauvwbxq55_OxnafZzT_EsNzo5Fvh0O0lIc7BOj72Uz83r0vM2emGr3R-7lGVx7YgatTjcdyCkc8eF-qEb6SkwWYSKtWjBrC01BByntkyClBgYhTgNQ3JsObOLti2J_04odPHJb89lPmCCpiUGusOvf24GGzJr7eNZ6sKHg0jJTUrezaJhYLquY31xlLgqxObAzCjiIgPfGPh9_nrzKZ_IMCXAOrEITGtWxWXPpykGSYwTTcLowTo4ya9iDrGQ1KOXbtsq7x5PtqwyJY52ao8E4LXT_Q81K2i3uP0vLN0axx0X0Nuy3DqCvaWKZlAeO1Zh1Hg77ir4jenX8vCZRQNYGLcSBKqWK65NiSeVDvyrxEB6yfEQTTVJHgj9furX6H4mCaHA2zAnK1Gb0w3sRGmmzFHW8-BWKZYRzQQ7MHtih9R6GQEWy8gL8EmNB7sWwU_R3bbSXng0VSq6Zl9MQyjgIFVSxFX-oeQHJvYyjqA1JgC3KHn0LM6zAjE63zKuaInuhIEW_bD3S9oYVTNmNlLZMWD3KBcOS6C7Z9AKXygxLORunBxy_b5C4CB3I_nFviEbi07_8QgfsnJwSjRDzJDv4vA8Fpo6TZG7Kd0R_UOWCWw8S5j9pVvlGDXo7pgdfkNS56L6w9iVZDSpGpylY1EJLFR9Nl5KHeOfmMstDAEd6yE4LauDvJqsDCoLm1d3PGfhHabAX-BKX-N7Zvxa6TZyUkFln3yOUpaFa9W8kf-e0M1GKgVZIU26SxMXtFtik4EzXc4o79tHWJi3bCyHcW8JE3H85r-AP9CTSTcT5svUwmLZ8q3YMz9-wo5bXYoCKAlwZ2uwTRg=w594-h742-no?authuser=0");
                //tạo tập mới
                Tap k = new Tap(Ten, linkss);
//                String Tenn = "Tập 2: Bánh quy biến hình";
//                List<String> links = new ArrayList<>();
//                links.add("https://file.nhasachmienphi.com/jpg/nhasachmienphi-truyen-tranh-doremon-333104-1.jpg");
//                links.add("https://file.nhasachmienphi.com/jpg/nhasachmienphi-truyen-tranh-doremon-333104-2.jpg");
//                links.add("https://file.nhasachmienphi.com/jpg/nhasachmienphi-truyen-tranh-doremon-333104-3.jpg");
//                links.add("https://file.nhasachmienphi.com/jpg/nhasachmienphi-truyen-tranh-doremon-333104-4.jpg");
//                links.add("https://file.nhasachmienphi.com/jpg/nhasachmienphi-truyen-tranh-doremon-333104-5.jpg");
//                links.add("https://file.nhasachmienphi.com/jpg/nhasachmienphi-truyen-tranh-doremon-333104-6.jpg");
//                links.add("https://file.nhasachmienphi.com/jpg/nhasachmienphi-truyen-tranh-doremon-333104-7.jpg");
//                links.add("https://file.nhasachmienphi.com/jpg/nhasachmienphi-truyen-tranh-doremon-333104-8.jpg");
//                Tap kk = new Tap(Tenn, links);
                //add tập
                taps.add(k);
//                taps.add(kk);
                //mảng truyện
                List<Truyen> truyens = new ArrayList<>();
                //tạo object truyện
                Truyen a = new Truyen("Tôi yêu cậu, còn cậu", "https://cdn-4.ohay.tv/imgs/f3d3c1a2751e4c10824e/728.jpg", taps, "Cẩm thương");
                //tên tập
                String tiQuay = "Chờ một ngày nắng để quên anh";
                //mảng link
                List<String> link_tiQuay = new ArrayList<>();
                link_tiQuay.add("https://jes.edu.vn/wp-content/uploads/2021/07/Nhung-manga-tinh-cam-hay-nhat.jpg");
                link_tiQuay.add("https://lh3.googleusercontent.com/9oE2aligHqfmMyi5IDXm0fVJWftOvlsOmVuqoTnTBI4MGHKLH2hvksp1jhzbvWCIDb7ge-wAnw72bf5VJc5AZ39gd89k1FSnCMSwrN_09wUVopYQ3ybxQlEyNJQOqPTAdomwWx29fvGOHM95rFTksle07inE1lXZpS5y6vRO-XusgW79_IN54-RIycNrdiHIIKZkXk6ApD7VHJyt89fXLGCSYOa_YI8QkRoPLC4XMxoVsUTgi-gmwuKQkPY76z8S6M3i8zge4IVSlrl-Oc1-LEKf0YFvsjsoe50Gt0kIKF09pchaDoYlmTVFEcmdnSDOu4W2MhZFwEGmT-1M6G3Z4_N9-2EguMLgngHJ9JzYBDLOqiy4qjr2NXXeiT_rsG_MaqImyfwfwZS7WVUvwxRFX99L8hDV5mxl3ma3FMDcB-Go9bxwNnngdjL_hxu1isBjXSUcD84wgk3ann09A0zwxPgx3n3HaFV3_uC9MrP1LNqd_iS0_Ow2h1M24WAnKiAD57N0k4ZyFS0U0aINph7vgCQGC_8L_gyxGtvvk-AS6w2MWkNguOGuXhOKyYLmBkJI9m0MrSg-nm7tQlGmzBtpvpLFgo-cBUp59ItDlV3C7tUmMiH2H_TGP_IcPBwV0aRxt2hZp8SYdddJYKzy-A56UXIyMSK8DXdJXWktbEZCOP0OxzreoV7NqjaIs9EgpF3myOQx42Y6vRDyjVlRI8s0FhyKVC5HJ2ubZJgpoAfMRW163dke1HcjH3palnuS2GZsiSKZZLX8K5HsTo0D2CPPUtvs06nfiQaRaBwz6zazSYprtnqddWK5CSWcgsgA2Qf5QInj8kIurhU6599wUBuQEt1wvtzXfa4MnWj_qhjG5W0PIjhlr0gBDQPprPrqAPY6I7EpqcoZhmh3_RJALgir5bQtEynRu8RpdfmcwFA0O_M=w615-h847-no?authuser=0");
                link_tiQuay.add("https://lh3.googleusercontent.com/XiqMpuGBAggbEDCq-ASslBaYakAYZVhb2QL2XbceWstrnEDpvj5pl03qchSV7KYs179T0kU0cj2hvqKtPQBDrulzrpHYNivbmNDyAbGx-wbsMOA5xg1DXtHC4fhXOiwm3tN0VdjGHqm7HOm-WCyhnqmKNPIS5A_a5gvOVgnaNqnvbD8VFVIewzfzGzRf2HXluJRrO6-d2qg9EgMabGM52qPIISmovQBCq1cg15ay0DYcgZ7HjtV-7lVmzObafPKGoElpWMNqxACMeOahpFS5H4wGdn84LY7D4EfN2oY8YjQ10mAQoV0OWH8Dt6s85MCbAyiDl8-jmvHaaTNQ0Au6wPzsYf01pxmmZGsSp72cVqCt4-qBksI6lCMlTj83oeN4XMp9i4rnb1ClYp342MWX0qRVpMLx2VPo7CtkISMZn1FVAC7gGiinw_mPaBw_J3MrWlmFJLgd4Jlg3lWvrq3OIrkQs_F6mpewOUh89qyhZC55jvBzxJ19U2oiXhzHNIARX2D069Rzsg1yDLHCE-9-9YvLadrE0KjcGEyBQVQwB_CJMGzBtSrOd59NAKkWPZGbpDC1-0u5rasndkcYuXATSvW3ms2za3usIlNXtLBGQfkaAnKIseuqafQIVxln6H9NyvOfY-ZmXlgD-U8ToGqkORMRT6mXQapWOAfeckhSMGvA0NKN_puF08jLd81Mg4xeUpIkCHD2jFrhjnVbySUVLOCxCDlVVZKdUWBfpB2xHxKjLneIcLZLklGxBs74pXpdjRENZr91R_SYb3DMPUC1KxF3nzkjgd4IfNhoT4iNYoTRWzOTqcdLJUJcGIVRahdRsKprDqtkv6j52EWfq1pa6bRMwJc2kjo6pEcO3YnbnbN8AQf_DNB7CQcBc9kvnwjJ-a-EiLjinXT71AOa5_FWWxyRj4IMuU5AvI1tDRmVJms=w606-h840-no?authuser=0");
                link_tiQuay.add("https://lh3.googleusercontent.com/ql055J8avU2Dtwa2UOMoq8owLcfcz77UjAyzLlj36o1912GK7Nv0KI5auE7hDo6f0BLW8YyN-XNxc7tCHjUzZDkfyUwJ4H-qnAi4h3uEyULq__jfNWNrJM-6wF40TLdVqWHPcOrof9cyG64xpAOlYkeIZDYlmDAYSRRfpLwlNKKVXs1cXFXL8wUE6S_ZaJ0HFRZe3ClBCx1N01o-GhYd0fTlTha7UDmr3JBJE77ThKdtwqXTPlfvyu6nHv-eF7AftSb68w0ruIpKUW9Kt4WeXdeDA_wEgSqtwJ2ARxuZC8dCKE40WWOCEam7Z3oyxagu_ipVcQK8zcRv4DoFLY6mrGFv5NcHrjykVXytrGwwD3ZShUXKKjVZRvjXO6WzGM-KCJR3hPDb8d6NxrTtQ-pgtOJKVnbGWANXJbT1XO5wQ0MuOm8FNTmIxZ0pWt2aZqD56NGtsRKurUrLSJDJOW8aZwImagQiA7C8sDvf3gHVyegZahx7pyrVECsaComr_8uyQ9yn63m-W9A4QuauEFmOqHR1JDgnUU-T7SJdW4G1nrwn2I0t7AlbLtsX51iWihAqVC2OSFT1s6wbF-CyrtIXdNRhipsKYA9WfCjvjywHERHAg5B_YL1hUkq29WCDTzvhTnWfc3Wwju-CKL8wBhGQflUN-NE3XmJ5MwlqT4xzmZrrOvMFFy3GVd4hH5WeynBBIkIjlUoxmRTnf34tYFUgM5ALRNYtCxVlDzzmI2YtGRO6eX3tf-MkhM-VXNxrw2MwsQ4Sx7a5hfhPaOW0N3j_fjtjGATAe4R1amxQwiottII0CzjB2UlvLF7EuarsdOdVZWwWQc1F0ELH8oWuchUzi4t_x7wajNuu9Fo1_yR_Rnk94KAGYrrmzwCvNs90AOidVH7VzPu-jMhwDTkeqNkqlmx62AWrXJFNQOCj67ws5fA=w617-h839-no?authuser=0");
                link_tiQuay.add("https://lh3.googleusercontent.com/NK3N-mWv46HAJsN4R_cxAgznkkL0IkMxYHqVXomrmLKA-SIm0fMsT8C79_bGEHKy-6kpRM8An3o1XHXJUbZa8xcJ5AGIKP78Cx5P0Rjh6mSzAGCXXI7-5xbjPzDCk4XSjfkUYvs9u-a3BrkyDo1t3fl9kg7X6H-0taOt3A5i0KgOEd3KZWvwapGUFmXcBRbR0J12CEOiU6OzicnVVTMXZzaSZhhRxZCeSHPiBLk9tKgXu2-gzj_rg6EyQtMEtD3l75LHDD9QBEmzvLvOpJR_Wuml7pCcQiKajj0lPPeQAQTusWj3_Mk27GPjP4mbOw2GSYKxajT0lYjzPzcsSJqMdYnA-N3zymGrnWGyMhZKrvYHn9UHr2AXib0ix7z_WmztcPN6eZlBkKqymPE5T34soAPkHR1hKJzCmjUBb_k7bFIPXqGZCprc9B8ZDTlXqOuPeaYsAoxMlJvtw37pZVurMktUkAyLZfQm71AEzmIw2A3VB7cegv9VZGNddYBCnTBkjmDuCahC2zrPD-Btu5RMpxTp2NXDLnlyWVhTlvjIfyhyjNULG8YKuonaF7Nfb6jTgwY1e92GmgMaMAKhBXqgPfgIRQOoxrp8nA2xLJOeX1HxSylGPz38WkgnwG1eQyeK9MVv5TEXlrGacs4hW4VlEvWvaDA0vI5QqWfkjt4lFeEL2uXjZ7BKnZ7gqtTjm_BmYMQuYkRdzYoAwO_zKd8yjMW0b_8POVLKAGRuYMfEfm_ocC4WhNrg1C7zs54BGtBG0mywFI8rod889bKndPnjIXph6ouidcpPST-1CA1d97lOJ6ya4-VIvmpnVT0t0CTXYabcI-MZ2v0LNkJSseuNIyuOmu0EMlqbaEGz_jir1MjVOp52DQQu8qYSc4BWxTA2XIqgCKXQ6l8N57E_r6x4pxClq6_wPa9dCamZZqdvUbI=w618-h839-no?authuser=0");
                link_tiQuay.add("https://lh3.googleusercontent.com/FdiScvzSv-1SUwba_sixRrFF6R-fEy9ee_TnR72QyquMLXXqbODj-HDZgnUCZpeR4xU9tcuGQZjRAFLGZ0hf2B4o0FsQJyCgPQJtQ-ITTSOGCP-par3vXnd7RRBYRB2tDup_tgbDpBIquvW2RfPirPFsjT255xs8iLSJ1EXQa3XEotRZeaariMWqRpdwydGXRM2H9PyKAk95_cGuZQbzUGOkZ27t__B4bJ7NmDi_bI7tnVCrZqQentmvgHVk9BlA_m4mua1LW29nS73U75ImYqZXdPIkKYUNeZZERtSADagqYzXZI5-6fatIztNCyFOhX3IfT_dqO9020IohMregRMx45xaGkr_TxpsOU9ByoxoW6lFmUjrJjh5ndAvVQWxxjHPCgA6l5qqL75P2RT1J5N-PQO10azoHDdukJAOMftPrzOIik4b7GlK3cCsTVEyiAPOagmBKavHAs81x3rNDOxNkwh07zRU-lnUtrqhZUmnqNneexGSaGu6qLc6v2bky7ulnDn6KTCebktUVKoS3Y9ypoAcEXriKk_pf3uppjDNf6cTwbo3yKsqc1gWrpeDURyu4gfci8myGHD3Yd1NI7AtwU45Kelk85rhn5PFTqqIcclsIzw7HedLnVItYnTtDU12N2pxq3MnheKs9OZ85tCJ2-Fw9CuIc9lqtLJNigzbCluqSsWi0QI7U6ZojNR1MOQBbfsbRJikq6SRrUE8OUixYcIDy785IEikfnXA96vbosdJChZNAvaA14bDig_9UIUW4bjv7ERSLAhexxeRNGoRpt86NUDjwF1EL2XGWpww2VfwCm16oqOuqo61P2q-qu6QUJ8QpXuBcCZM7AiHHWiMcjMYYDAZkFdtuUA2bUNlU-FPONzcOC2Kc_GO7O5xFgTLfOmTxKkOYqVFCBtjCFXts7MXbiuVU_BE_pcsr9dg=w595-h845-no?authuser=0");

                //object tập
                Tap tiQ = new Tap(tiQuay, link_tiQuay);
                //add tập
                List<Tap> t = new ArrayList<>();
                t.add(tiQ);
                //mảng truyện
                List<Truyen> truyens11 = new ArrayList<>();
                //add object 1
                truyens11.add(a);
                //add object 2
                Truyen b = new Truyen("Chờ một ngày nắng để quên anh", "https://jes.edu.vn/wp-content/uploads/2021/07/Nhung-manga-tinh-cam-hay-nhat.jpg", t, "Cẩm thương");
                truyens11.add(b);
                PhanLoai pl = new PhanLoai("Truyện ngôn tình", "https://truyengiaoduc.com/wp-content/uploads/2018/05/truyen-giao-duc.png", truyens11);
                databaseReference.child("Truyện ngôn tình").setValue(pl);
            }
        });

    }
}