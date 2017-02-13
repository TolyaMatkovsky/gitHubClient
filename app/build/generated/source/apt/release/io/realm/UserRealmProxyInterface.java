package io.realm;


public interface UserRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public String realmGet$loginName();
    public void realmSet$loginName(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$email();
    public void realmSet$email(String value);
    public String realmGet$company();
    public void realmSet$company(String value);
    public String realmGet$avatarURL();
    public void realmSet$avatarURL(String value);
    public String realmGet$htmlURL();
    public void realmSet$htmlURL(String value);
    public int realmGet$followers();
    public void realmSet$followers(int value);
    public int realmGet$following();
    public void realmSet$following(int value);
    public int realmGet$publicGists();
    public void realmSet$publicGists(int value);
    public int realmGet$publicRepos();
    public void realmSet$publicRepos(int value);
    public RealmList<com.example.app.testapp.data.entity.UserRepository> realmGet$repositories();
    public void realmSet$repositories(RealmList<com.example.app.testapp.data.entity.UserRepository> value);
}
