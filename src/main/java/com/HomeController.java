package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.print.attribute.standard.PresentationDirection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@Controller

public class HomeController {
    private DataSource dataSource;
    public HomeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @RequestMapping("/tax")
    public String tax(Model model){
        return "homepage";
    }

    @RequestMapping("/tax/calculate")
    public String tax(@ModelAttribute("category") String category, @ModelAttribute("zone") String zone, @ModelAttribute("salary") long salary, @ModelAttribute("hrent") long hrent, @ModelAttribute("med") long med, @ModelAttribute("con") long con, @ModelAttribute("ot") long ot, @ModelAttribute("fbonus") long fbonus, @ModelAttribute("invest") long invest, Model model){

        model.addAttribute("category", category);
        model.addAttribute("zone", zone);
        model.addAttribute("salary", salary);
        model.addAttribute("hrent", hrent);
        model.addAttribute("med", med);
        model.addAttribute("con", con);
        model.addAttribute("ot", ot);
        model.addAttribute("fbonus", fbonus);
        model.addAttribute("invest", invest);

        long total = salary+hrent+med+con+ot+fbonus;
        model.addAttribute("total", total);
        long taxpayable = 0;
        long tax = 0;
        long nimo = 0;
        String general = "";
        long catvalue = 0;
        long taxammfive = 0;
        long taxammten = 0;
        long taxammfiften = 0;
        long taxammtwenty = 0;
        long taxammtwentyfive = 0;


        long taxfive = 0;
        long taxten = 0;
        long taxfiften = 0;
        long taxtwenty = 0;
        long taxtwentyfive = 0;


        long ten = (salary * 10L)/100;
        long fifty = (salary * 50L)/100;

        model.addAttribute("fifty", fifty);
        model.addAttribute("ten", ten);


        if(salary>0){
            taxpayable = taxpayable + salary;
        }

        long hta = 0;
        long maxhta = 0;
        if(hrent > fifty || hrent > 300000){
            if(fifty > 300000) {
                nimo = hrent - 300000;
                hta = nimo;
                maxhta = 300000;
                taxpayable = taxpayable + nimo;
            }
            else{
                nimo = hrent - fifty;
                hta = nimo;
                taxpayable = taxpayable + nimo;
                maxhta = fifty;
            }
        }
        model.addAttribute("maxhta", maxhta);
        model.addAttribute("hta", hta);

        long meda = 0;
        if(med > ten){
            nimo = med - ten;
            meda = nimo;
            taxpayable = taxpayable + nimo;
        }
        model.addAttribute("meda", meda);

        long cont = 0;
        if(con>30000){
            nimo = con - 30000;
            cont = nimo;
            taxpayable = taxpayable + nimo;
        }
        model.addAttribute("cont", cont);

        taxpayable = taxpayable + ot;
        taxpayable = taxpayable + fbonus;

        if(category.equals("Female/Senior Citizen")){
            general = "Upto 350000 Taka";
            catvalue = 350000;
            if(taxpayable > 350000 && taxpayable < 450000){
                nimo = taxpayable - 350000;
                tax = (nimo*5)/100;
                taxammfive = nimo;
                taxfive = tax;
            }
            if(taxpayable > 450000 && taxpayable<750000){
                nimo = taxpayable - 450000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (nimo*10)/100;
                taxammfive = 100000;
                taxammten = nimo;
                taxten = tax - taxfive;
            }
            if(taxpayable > 750000 && taxpayable<1150000){
                nimo = taxpayable - 750000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (nimo*15)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = nimo;
                taxfiften = tax - (taxfive + taxten);
            }
            if(taxpayable > 1150000 && taxpayable<1650000){
                nimo = taxpayable - 1150000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (400000*15)/100;
                taxfiften = tax - (taxfive+taxten);
                tax = tax + (nimo*20)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = 400000;
                taxammtwenty = nimo;
                taxtwenty = tax - (taxfive+taxten+taxfiften);
            }
            if(taxpayable > 1650000){
                nimo = taxpayable - 1650000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (400000*15)/100;
                taxfiften = tax - (taxfive+taxten);
                tax = tax + (500000*20)/100;
                taxtwenty = tax - (taxfive+taxten+taxfiften);
                tax = tax + (nimo*25)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = 400000;
                taxammtwenty = 500000;
                taxammtwentyfive = nimo;
                taxtwentyfive = tax - (taxfive+taxten+taxfiften+taxtwenty);
            }
        }




        if(category.equals("General")){
            general = "Upto 300000 Taka";
            catvalue = 300000;
            if(taxpayable > 300000 && taxpayable < 400000){
                nimo = taxpayable - 300000;
                tax = (nimo*5)/100;
                taxammfive = nimo;
                taxfive = tax;
            }
            if(taxpayable > 400000 && taxpayable<700000){
                nimo = taxpayable - 400000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (nimo*10)/100;
                taxammfive = 100000;
                taxammten = nimo;
                taxten = tax - taxfive;
            }
            if(taxpayable > 700000 && taxpayable<1100000){
                nimo = taxpayable - 700000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (nimo*15)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = nimo;
                taxfiften = tax - (taxfive + taxten);
            }
            if(taxpayable > 1100000 && taxpayable<1600000){
                nimo = taxpayable - 1100000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (400000*15)/100;
                taxfiften = tax - (taxfive+taxten);
                tax = tax + (nimo*20)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = 400000;
                taxammtwenty = nimo;
                taxtwenty = tax - (taxfive+taxten+taxfiften);
            }
            if(taxpayable > 1600000){
                nimo = taxpayable - 1600000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (400000*15)/100;
                taxfiften = tax - (taxfive+taxten);
                tax = tax + (500000*20)/100;
                taxtwenty = tax - (taxfive+taxten+taxfiften);
                tax = tax + (nimo*25)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = 400000;
                taxammtwenty = 500000;
                taxammtwentyfive = nimo;
                taxtwentyfive = tax - (taxfive+taxten+taxfiften+taxtwenty);
            }
        }



        if(category.equals("Disable")){
            general = "Upto 450000 Taka";
            catvalue = 450000;
            if(taxpayable > 450000 && taxpayable < 550000){
                nimo = taxpayable - 450000;
                tax = (nimo*5)/100;
                taxammfive = nimo;
                taxfive = tax;
            }
            if(taxpayable > 550000 && taxpayable<850000){
                nimo = taxpayable - 550000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (nimo*10)/100;
                taxammfive = 100000;
                taxammten = nimo;
                taxten = tax - taxfive;
            }
            if(taxpayable > 850000 && taxpayable<1250000){
                nimo = taxpayable - 850000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (nimo*15)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = nimo;
                taxfiften = tax - (taxfive + taxten);
            }
            if(taxpayable > 1250000 && taxpayable<1750000){
                nimo = taxpayable - 1250000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (400000*15)/100;
                taxfiften = tax - (taxfive+taxten);
                tax = tax + (nimo*20)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = 400000;
                taxammtwenty = nimo;
                taxtwenty = tax - (taxfive+taxten+taxfiften);
            }
            if(taxpayable > 1750000){
                nimo = taxpayable - 1750000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (400000*15)/100;
                taxfiften = tax - (taxfive+taxten);
                tax = tax + (500000*20)/100;
                taxtwenty = tax - (taxfive+taxten+taxfiften);
                tax = tax + (nimo*25)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = 400000;
                taxammtwenty = 500000;
                taxammtwentyfive = nimo;
                taxtwentyfive = tax - (taxfive+taxten+taxfiften+taxtwenty);
            }
        }




        if(category.equals("Gazetted Freedom Fighters")){
            general = "Upto 475000 Taka";
            catvalue = 475000;
            if(taxpayable > 475000 && taxpayable < 575000){
                nimo = taxpayable - 475000;
                tax = (nimo*5)/100;
                taxammfive = nimo;
                taxfive = tax;
            }
            if(taxpayable > 575000 && taxpayable<875000){
                nimo = taxpayable - 575000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (nimo*10)/100;
                taxammfive = 100000;
                taxammten = nimo;
                taxten = tax - taxfive;
            }
            if(taxpayable > 875000 && taxpayable<1275000){
                nimo = taxpayable - 875000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (nimo*15)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = nimo;
                taxfiften = tax - (taxfive + taxten);
            }
            if(taxpayable > 1275000 && taxpayable<1775000){
                nimo = taxpayable - 1275000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (400000*15)/100;
                taxfiften = tax - (taxfive+taxten);
                tax = tax + (nimo*20)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = 400000;
                taxammtwenty = nimo;
                taxtwenty = tax - (taxfive+taxten+taxfiften);
            }
            if(taxpayable > 1775000){
                nimo = taxpayable - 1775000;
                tax = (100000*5)/100;
                taxfive = tax;
                tax = tax + (300000*10)/100;
                taxten = tax - taxfive;
                tax = tax + (400000*15)/100;
                taxfiften = tax - (taxfive+taxten);
                tax = tax + (500000*20)/100;
                taxtwenty = tax - (taxfive+taxten+taxfiften);
                tax = tax + (nimo*25)/100;
                taxammfive = 100000;
                taxammten = 300000;
                taxammfiften = 400000;
                taxammtwenty = 500000;
                taxammtwentyfive = nimo;
                taxtwentyfive = tax - (taxfive+taxten+taxfiften+taxtwenty);
            }
        }

        long maxinvest = (total*25)/100;
        long rivtax = 0;
        long rebate = 0;

        if(invest > maxinvest){
            if(maxinvest <1500000){
                rebate = (maxinvest*15)/100;
            }
            else{
                rebate = (maxinvest*10)/100;
            }
        }
        if(invest < maxinvest){
            if(invest <1500000){
                rebate = (invest*15)/100;
            }
            else{
                rebate = (invest*10)/100;
            }
        }

        long nettax = tax - rebate;

        if(rebate > tax){
            nettax = 0;
        }
        long mnettax = nettax/12;

        long mtax = Math.round(tax / 12);
        tax = Math.round(tax);
        taxpayable = Math.round(taxpayable);

        model.addAttribute("mnettax", mnettax);
        model.addAttribute("maxinvest", maxinvest);
        model.addAttribute("rebate", rebate);
        model.addAttribute("nettax", nettax);
        model.addAttribute("tax", tax);
        model.addAttribute("taxpayable", taxpayable);
        model.addAttribute("mtax", mtax);
        model.addAttribute("a",general);
        model.addAttribute("avalue", catvalue);
        model.addAttribute("taxammfive", taxammfive);
        model.addAttribute("taxammten", taxammten);
        model.addAttribute("taxammfiften", taxammfiften);
        model.addAttribute("taxammtwenty", taxammtwenty);
        model.addAttribute("taxammtwentyfive", taxammtwentyfive);
        model.addAttribute("taxfive", taxfive);
        model.addAttribute("taxten", taxten);
        model.addAttribute("taxfiften", taxfiften);
        model.addAttribute("taxtwenty", taxtwenty);
        model.addAttribute("taxtwentyfive", taxtwentyfive);



        //System.out.println(tax);


        return "taxshow";
    }








}
