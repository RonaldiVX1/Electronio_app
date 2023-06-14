package com.example.electronioproject.ui.screen.profile.profile_menu.terms_conditions

data class TermsAndConditionsModel(
    val title: String,
     val description: String,
)


object TermsAndConditionData {
    val dataTermsAndConditions = listOf(
        TermsAndConditionsModel(
            "Acceptance of Terms",
            "By accessing or using Electronio, you acknowledge that you have read, understood, and agreed to these Terms and Conditions. If you do not agree to these terms, you must refrain from using the app."
        ),
        TermsAndConditionsModel(
            "Use of the App",
            "2.1 License: Electronio grants you a limited, non-exclusive, non-transferable, revocable license to use the app for personal, non-commercial purposes. You may not use Electronio for any illegal or unauthorized purposes.\n" +
                    "2.2 Age Restriction: You must be at least 13 years old to use Electronio. If you are under the age of 18, you must obtain consent from a parent or guardian to use the app.\n" +
                    "2.3 Account Creation: To access certain features of Electronio, you may need to create an account. You are responsible for maintaining the confidentiality of your account information and for any activity that occurs under your account."
        ),
        TermsAndConditionsModel(
            "Intellectual Property Rights",
            "3.1 Ownership: Electronio and its licensors retain all intellectual property rights in the app. You agree not to reproduce, modify, distribute, or create derivative works based on Electronio without prior written consent.\n" +
                    "3.2 User Content: By using Electronio, you grant Electronio a non-exclusive, royalty-free, worldwide, perpetual license to use, display, and distribute any content you submit through the app for the purpose of operating and improving Electronio."
        ),
        TermsAndConditionsModel(
            "Privacy",
            "4.1 Privacy Policy: Electronio collects, stores, and processes personal information in accordance with its Privacy Policy. By using the app, you consent to such collection, storage, and processing of your information as described in the Privacy Policy.\n" +
                    "4.2 Data Security: While Electronio takes reasonable measures to protect user data, you acknowledge that no method of transmission or storage is 100% secure, and Electronio cannot guarantee the absolute security of your data."
        ),
        TermsAndConditionsModel(
            "Limitation of Liability",
            "5.1 Disclaimer of Warranties: Electronio is provided on an \"as-is\" and \"as available\" basis, without warranties of any kind, either express or implied. Electronio does not warrant that the app will be uninterrupted, error-free, or secure.\n" +
                    "5.2 Limitation of Liability: In no event shall Electronio or its affiliates be liable for any indirect, incidental, special, or consequential damages arising out of or in connection with the use of Electronio, even if advised of the possibility of such damages."
        ),
        TermsAndConditionsModel(
            "Modification and Termination",
            "Electronio reserves the right to modify, suspend, or terminate the app or these Terms and Conditions at any time without prior notice. You agree that Electronio shall not be liable to you or any third party for any modification, suspension, or termination of the app."
        ),
        TermsAndConditionsModel(
            "Governing Law and Jurisdiction",
            "These Terms and Conditions shall be governed by and construed in accordance with the laws of [Jurisdiction]. Any disputes arising out of or in connection with these Terms and Conditions shall be submitted to the exclusive jurisdiction of the courts of [Jurisdiction]."
        )
    )
}