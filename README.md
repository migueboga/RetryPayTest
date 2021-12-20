<p align="center">
  <a href="" rel="noopener">
 <img width=200px height=200px src="https://i.imgur.com/6wj0hh6.jpg" alt="Project logo"></a>
</p>

<h3 align="center">RetryPayTest</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![GitHub Issues](https://img.shields.io/github/issues/kylelobo/The-Documentation-Compendium.svg)](https://github.com/kylelobo/The-Documentation-Compendium/issues)
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/kylelobo/The-Documentation-Compendium.svg)](https://github.com/kylelobo/The-Documentation-Compendium/pulls)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

---

<p align="center"> Android Sdk to retrive data for Rick &amp; Morti API
    <br> 
</p>

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Usage](#usage)
- [Authors](#authors)

## 🧐 About <a name = "about"></a>

The purpose of this project is an easy way to retrive data from Rick & morti API (https://rickandmortyapi.com/api).

## 🏁 Getting Started <a name = "getting_started"></a>

Require Android Studio with Grandle 7.3.2+ and Gradle Plugin 4.1.3+. 
Also the SDK require one permission: android.permission.INTERNET

### Prerequisites

No one.

### Installing

(fictitious): Add this dependency to your build.gradle (app level):

```
implementation 'com.retrypay.rickandmorti:1.0.0'
```

Or:

1. Download this repository.
2. Import the app folder to your android project with the name rickandmorti.
3. Add to your build.gradle (app level):

```
implementation project(path: ':rickandmorti')
```

You can check the example in this project.

## 🔧 Running the tests <a name = "tests"></a>

Coming soon.

## 🎈 Usage <a name="usage"></a>

1. Initialize the PersonRepository class:

```
val personRepository: PersonRepository = PersonRepository()
```
The PersonRepository class contain the functions to retrive data from API about the persons that participe in Rick and Morti tv show.

2. You can call these functions using an observable retrive livedata object. If you require get all persons is like this:

```
personRepository.getAllPersons(null).observe(this) {
            when(it.status) {
                ResourceStatus.SUCCESS -> {
                    // Do something with data
                    setResponseText(it.data.toString())
                }
                ResourceStatus.LOADING -> {
                    // Show loading to user
                }
                ResourceStatus.ERROR -> {
                    it.message?.let {
                        // Show message to user
                    }
                }
            }
}
```
Note: Pagination can be set by some number page in the parameter of the function getAllPersons.

You can check all examples in this project.


## ✍️ Authors <a name = "authors"></a>

- Miguel Bogarin -
