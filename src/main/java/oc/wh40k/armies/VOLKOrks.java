package oc.wh40k.armies;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

import java.io.InputStream;

public class VOLKOrks extends BuildaVater {

    public VOLKOrks() {

        reflectionKennung = "OR";
        InputStream is = this.getClass().getResourceAsStream("/oc/wh40k/indices/or.csv");
        pointValues = BuildaHQ.loadindexFile(is);

        AdditionalInformation = new String[]{""};
        HQeinträge = new String[]{""};
        Eliteeinträge = new String[]{"", "Custodian Guard Squad"};
        Standardeinträge = new String[]{""};
        Sturmeinträge = new String[]{""};
        Unterstützungeinträge = new String[]{""};
        Transporteinträge = new String[]{""};
        Fliegereinträge = new String[]{""};
        Befestigungen = new String[]{""};
        LordofWar = new String[]{""};

        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, AI, AdditionalInformation));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HQ, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, TR, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, EL, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FA, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, HS, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, DT, Transporteinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FL, Fliegereinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, FORT, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, LOW, LordofWar));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        volk = "Orks";
        nameDerArtDerArmee = "Orks";
        nameDerArtDerArmeeDekliniert = "der Orks";

        textAreaUeberschrift = BuildaHQ.translate("Mein") + " Waaagh!";

        noAllies.clear();
        noAllies.add("OR");
        noAllies.add("DM");

        battleBrothers.add("OR");
        battleBrothers.add("DM");

        alliesOfConvenience.add("BL");
        alliesOfConvenience.add("CM");
        alliesOfConvenience.add("CS");
        alliesOfConvenience.add("RH");

        desperateAllies.add("CD");
        desperateAllies.add("DE");
        desperateAllies.add("DH");
        desperateAllies.add("EC");
        desperateAllies.add("EL");
        desperateAllies.add("HQ");
        desperateAllies.add("FE");
        desperateAllies.add("NE");
        desperateAllies.add("TA");

        comeTheApocalypse.add("AB");
        comeTheApocalypse.add("AM");
        comeTheApocalypse.add("AS");
        comeTheApocalypse.add("BA");
        comeTheApocalypse.add("CR");
        comeTheApocalypse.add("DA");
        comeTheApocalypse.add("DK");
        comeTheApocalypse.add("DKAB");
        comeTheApocalypse.add("ED");
        comeTheApocalypse.add("GK");
        comeTheApocalypse.add("IN");
        comeTheApocalypse.add("IR");
        comeTheApocalypse.add("MT");
        comeTheApocalypse.add("SF");
        comeTheApocalypse.add("SM");
        comeTheApocalypse.add("TL");
        comeTheApocalypse.add("TY");
        comeTheApocalypse.add("SY");
        comeTheApocalypse.add("DW");

        formationen.add("ORK");
        formationen.add("Goff");
        formationen.add("Blood Axe");
        formationen.add("Deathskulls");
        formationen.add("Evil Sunz");
        formationen.add("Snakebites");
        formationen.add("Bad Moonz");
        formationen.add("Freebooterz");

        complete();
    }

    public void changeFormations() {
    }

    @Override
    public void volkRefresh() {

        if (getFormationType().equals("ORK")) {
            myChooserGruppen.get(AI).changeComboBoxAuswahlen(new String[]{
                    "", "Warlordtraits"/*, "Artefacts"*/});

            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Deffkilla Wartrike",
                    "", "Big Mek in Mega Armour", "Big Mek with Shokk Attack Gun",
                    "", "Weirdboy",
                    "", "Ghazghkull Thraka", "Kaptin Badrukk", "Boss Zagstruk", "Boss Snikrot",
                    "", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Big Mek [Index]", "Big Mek on Warbike [Index]",
                    "", "Zhadsnark da Rippa [FW]", "Ork Mek Boss Buzzgob [FW]"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Kommandos",
                    "", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz",
                    "", "Mad Dok Grotsnik",
                    "", "Painboy on Warbike [Index]"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers",
                    "", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet",
                    "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]",});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans",
                    "", "Gorkanaut", "Morkanaut",
                    "", "Battlewagon", "Gunwagon", "Bonebreaka",
                    "", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Big Gunz [Index]",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]",
                    "Battlewagon with Supa-Kannon [FW]",});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk",
                    "", "'Chinork' Warkopta [FW]"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa",
                    "", "Kill Tank [FW]", "Kustom Stompa [FW]", "Gargantuan Squiggoth [FW]",});
        } else if (getFormationType().equals("Goff")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Deffkilla Wartrike",
                    "", "Weirdboy",
                    "", "Big Mek [Index]", "Big Mek in Mega Armour", "Big Mek on Warbike [Index]", "Big Mek with Shokk Attack Gun",
                    "", "Ghazghkull Thraka", "Boss Zagstruk",
                    "", "Ork Mek Boss Buzzgob [FW]"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Big Mek on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        } else if (getFormationType().equals("Blood Axe")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Deffkilla Wartrike",
                    "", "Weirdboy",
                    "", "Big Mek [Index]", "Big Mek in Mega Armour", "Big Mek on Warbike [Index]", "Big Mek with Shokk Attack Gun",
                    "", "Boss Snikrot"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Big Mek on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        } else if (getFormationType().equals("Deathskulls")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Deffkilla Wartrike",
                    "", "Weirdboy",
                    "", "Big Mek [Index]", "Big Mek in Mega Armour", "Big Mek on Warbike [Index]", "Big Mek with Shokk Attack Gun"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Big Mek on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos",
                    "", "Mad Dok Grotsnik"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        } else if (getFormationType().equals("Evil Sunz")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Deffkilla Wartrike",
                    "", "Weirdboy",
                    "", "Big Mek [Index]", "Big Mek in Mega Armour", "Big Mek on Warbike [Index]", "Big Mek with Shokk Attack Gun",
                    "", "Zhadsnark da Rippa [FW]"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Big Mek on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        } else if (getFormationType().equals("Snakebites")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Deffkilla Wartrike",
                    "", "Weirdboy",
                    "", "Big Mek [Index]", "Big Mek in Mega Armour", "Big Mek on Warbike [Index]", "Big Mek with Shokk Attack Gun"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Big Mek on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        } else if (getFormationType().equals("Bad Moonz")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Deffkilla Wartrike",
                    "", "Weirdboy",
                    "", "Big Mek [Index]", "Big Mek in Mega Armour", "Big Mek on Warbike [Index]", "Big Mek with Shokk Attack Gun"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Big Mek on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        } else if (getFormationType().equals("Freebooterz")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(new String[]{
                    "", "Warboss", "Warboss in Mega Armour [Index]", "Warboss on Warbike [Index]", "Deffkilla Wartrike",
                    "", "Weirdboy",
                    "", "Big Mek [Index]", "Big Mek in Mega Armour", "Big Mek on Warbike [Index]", "Big Mek with Shokk Attack Gun"});
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(new String[]{
                    "", "Boyz", "Gretchin"});
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(new String[]{
                    "", "Mek", "Painboy", "Big Mek on Warbike [Index]", "Runtherd",
                    "", "Burna Boyz", "Tankbustas", "Nobz", "Nob with Waaagh Banner", "Nobz on Warbikes", "Meganobz", "Kommandos"});
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(new String[]{
                    "", "Stormboyz", "Deffkoptas", "Warbikers", "Kustom Boosta-Blastas", "Shokkjump Dragstas", "Boomdakka Snazzwagons", "Rukkatrukk Squigbuggys", "Megatrakk Scrapjet", "", "Wartrakks [Index]", "Skorchas [Index]", "Warbuggies [Index]",
                    "", "Grot Tanks [FW]", "Grot Mega-Tank [FW]"});
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(new String[]{
                    "", "Deff Dreads", "Killa Kans", "Gorkanaut", "Morkanaut", "Battlewagon", "Gunwagon", "Bonebreaka", "Big Gunz [Index]", "Mek Gunz", "Lootas", "Flash Gitz",
                    "", "Squiggoth [FW]", "Meka-Dread [FW]", "Lifta Wagon [FW]", "Big Trakk [FW]", "Battlewagon with Supa-Kannon [FW]"});
            myChooserGruppen.get(DT).changeComboBoxAuswahlen(new String[]{
                    "", "Trukk"});
            myChooserGruppen.get(FL).changeComboBoxAuswahlen(new String[]{
                    "", "Dakkajet", "Burna-Bommer", "Blitza-Bommer", "Wazbom Blastajet"});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(new String[]{
                    "", "Stompa"});
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }

    @Override
    public void refreshAction() {
//		System.out.println("ORZhadsnark? "+BuildaHQ.getCountFromInformationVectorGlobal("ORZhadsnark"));
        if (BuildaHQ.getCountFromInformationVectorGlobal("ORZhadsnark") > 0) {
            myChooserGruppen.get(TR).addSpezialAuswahl("Warbikers");
        } else {
            myChooserGruppen.get(TR).removeSpezialAuswahl("Warbikers");
        }
        super.refreshAction();
    }

    @Override
    protected void finalize() {
        System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
    }

}