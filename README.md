# Minha-Pizzaria

### Descrição do Projeto

> Aplicativo feito em Kotlin e utilizando as bibliotecas Retrofit e Glide.

### Instalação

Para começar, inclua as seguintes dependências adicionando ao `build.gradle` do módulo do projeto e após isso atualize o `Gradle`:

```groovy
plugins {
    id 'kotlin-parcelize'
    id "androidx.navigation.safeargs.kotlin"
}
android {
        defaultConfig {
        ...
        //VectorDrawables
        vectorDrawables.useSupportLibrary = true
        }
        buildFeatures{
        
        //ViewBinding
        viewBinding true
        }

dependencies {
    //Principais dependências
    
    //Navigation View
    implementation 'androidx.navigation:navigation-fragment-ktx:2.3.5'
    implementation 'androidx.navigation:navigation-ui-ktx:2.3.5'
    
    //Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.6.0'
    
    //Glide
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
    ...
}
```
Depois, inclue a seguinte linha `build.gradle` no módulo do projeto e atualize o `Gradle`:

```groovy
 buildscript {
    ext.nav_version = "2.3.4"
    ...
 dependencies {
        //Navigation View e Safe Args
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
        ...
    }
    
```

Escreva a seguinte linha no `Android Manifest`:

```xml
//Permissão de Internet
<uses-permission android:name="android.permission.INTERNET" />
```

### Telas do aplicativo 

A figura abaixo mostra as principais telas do aplicativo

|![](/tela_login.png) |![](/tela_escolha_pizza.png) |
|:---:|:---:|
| **Tela de Login** | **Tela de Escolha de Pizzas**  |
|![](/detalhes_pizza.png) |![](/tela_finalizacao_pedido.png) |
| **Tela de Detalhes de Pizzas**  |  **Tela de Finalização de Compras** |

