package com.example.dmall.controller;

import com.example.dmall.bean.FirstLevelCategory;
import com.example.dmall.bean.Msg;
import com.example.dmall.bean.Product;
import com.example.dmall.bean.ProductImage;
import com.example.dmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAllProduct")
    public List<Product> findAll()
    {
        List<Product> list=productService.listAllProduct();
        System.out.println("程序一直执行这个程序");
        return list;
    }

    @GetMapping("/findProductsByCategory/{category_id}")
    public Msg findProductsByCategory(@PathVariable(value = "category_id") Integer category_id)
    {
        System.out.println(" 打印产品id"+category_id);

        //第一步查出产品的信息
        List<Product> products=productService.findProductsByCategory(category_id);
        //第二步，遍历产品信息集合
        for(Product product: products)
        {
            //第三步，根据每个产品的id去productImages表中查询产品的图片。
            List<ProductImage> productImages=  productService.findProductSmallImage(product.getId());
            if(productImages.size()>0)
            {
                product.setSmallimage("images/item/productDetailsPicture/"+productImages.get(0).getSrc());
            }
        }
        return  new Msg().success("products",products);
    }

    @GetMapping("/findProductsByCategory")
    public Msg findProductsByCategory()
    {

        List<Map<String,Object>> list = new ArrayList<>();

        List<FirstLevelCategory> categories = productService.getFirstCategory();
        for(FirstLevelCategory category : categories) {
            Map<String,Object> map = new HashMap<>();
            map.put("category",category);
            //第一步查出产品的信息
            List<Product> products=productService.findProductsByCategory(category.getId());

            for(Product product: products)
            {
                //第三步，根据每个产品的id去productImages表中查询产品的图片。
                List<ProductImage> productImages=  productService.findProductSmallImage(product.getId());
                if(productImages.size()>0)
                {
                    product.setSmallimage("images/item/productDetailsPicture/"+productImages.get(0).getSrc());
                }
            }

            map.put("products",products);
            list.add(map);
        }


        //第二步，遍历产品信息集合

        return  new Msg().success("floors",list);
    }
}