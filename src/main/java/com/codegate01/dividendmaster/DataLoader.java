package com.codegate01.dividendmaster;

import com.codegate01.dividendmaster.model.ERole;
import com.codegate01.dividendmaster.model.Role;
import com.codegate01.dividendmaster.model.Stock;
import com.codegate01.dividendmaster.model.User;
import com.codegate01.dividendmaster.repository.RoleRepository;
import com.codegate01.dividendmaster.repository.StockRepository;
import com.codegate01.dividendmaster.repository.UserRepository;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
Tests only
This class will load some popular stocks in the S&P500
 */
@Component
public class DataLoader implements ApplicationRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final StockRepository stockRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public DataLoader(RoleRepository roleRepository, StockRepository stockRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.stockRepository = stockRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("DataLoader is running...");
        //LoadStocks();
    }

    /*
    CREATES THE DEFAULT APPLICATION ROLES
     */
    private void LoadRoles() {

        List<Role> roleList = new ArrayList<>();

        Role roleUser = new Role(ERole.ROLE_USER);
        roleList.add(roleUser);
        Role roleAdmin = new Role(ERole.ROLE_ADMIN);
        roleList.add(roleAdmin);
        Role roleMod = new Role(ERole.ROLE_MODERATOR);
        roleList.add(roleMod);

        roleRepository.saveAll(roleList);

    }

    private void LoadUsers() {
        List<User> userList = new ArrayList<>();

        User user = new User("admin", passwordEncoder.encode("admin"), "admin@gmail.com", ERole.ROLE_ADMIN);
        userList.add(user);
        User user2 = new User("mod", passwordEncoder.encode("mod"), "mod@gmail.com", ERole.ROLE_MODERATOR);
        userList.add(user2);
        User user3 = new User("user", passwordEncoder.encode("user"), "dev@gmail.com", ERole.ROLE_USER);
        userList.add(user3);

        userRepository.saveAll(userList);
    }

    private void LoadStocks() throws IOException {

        Stock stock = new Stock("T", "AT&T", "NYSE", "Communications",
                "AT&T Inc. provides telecommunication, media, and technology services worldwide."
                , "US", "www.att.com");
        stockRepository.save(stock);

/*
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://stock-market-data.p.rapidapi.com/market/exchange/nyse")
                .get()
                .addHeader("x-rapidapi-key", "")
                .addHeader("x-rapidapi-host", "stock-market-data.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();

        String jsonData = response.body().string();

        JSONObject jsonObject = new JSONObject(jsonData);
*/
/*
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://stock-market-data.p.rapidapi.com/market/index/s-and-p-five-hundred")
                .get()
                .addHeader("x-rapidapi-host", "stock-market-data.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "")
                .build();

        Response response = client.newCall(request).execute();

*/

    }
}
