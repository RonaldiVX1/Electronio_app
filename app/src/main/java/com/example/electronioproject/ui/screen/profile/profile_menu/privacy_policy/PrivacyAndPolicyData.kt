package com.example.electronioproject.ui.screen.profile.profile_menu.privacy_policy

data class PrivacyAndPolicyModel(
    val title: String,
    val description: String,
)

object PrivacyAndPolicyData {
    val dataPrivacyAndPolicy = listOf(
        PrivacyAndPolicyModel(
            "1. Information We Collect",
            "1.1 Personal Information: When you create an account or use certain features of the App, we may collect personal information such as your name, email address, and contact details. Providing this information is voluntary, but certain features may require it for full functionality.\n" +
                    "1.2 Usage Data: We may collect non-personal information about your use of the App, such as your device type, operating system, and app interactions. This data helps us improve the App and provide a better user experience."
        ),
        PrivacyAndPolicyModel(
            "2. Use of Information",
            "2.1 Personal Information: We use your personal information to provide and improve the App's functionality, respond to your inquiries, and communicate with you about updates, promotions, and relevant information.\n" +
                    "2.2 Usage Data: We use usage data to analyze trends, track App performance, and enhance user experience. This data is aggregated and anonymized to ensure your privacy."
        ),
        PrivacyAndPolicyModel(
            "3. Information Sharing and Disclosure",
            "3.1 Third-Party Service Providers: We may engage trusted third-party service providers to assist us in operating the App and delivering services to you. These providers have access to your information only to perform tasks on our behalf and are obligated to maintain its confidentiality.\n" +
                    "3.2 Legal Requirements: We may disclose your information if required to do so by law or in response to valid requests from governmental authorities."
        ),
        PrivacyAndPolicyModel(
            "4. Data Security",
            "4.1 Security Measures: We implement industry-standard security measures to protect your personal information from unauthorized access, disclosure, or alteration. However, please note that no method of data transmission or storage is 100% secure, and we cannot guarantee absolute security.\n" +
                    "4.2 Retention: We retain your personal information only for as long as necessary to fulfill the purposes outlined in this Privacy Policy unless a longer retention period is required or permitted by law."
        ),
        PrivacyAndPolicyModel(
            "5. Third-Party Links and Services",
            "The App may contain links to third-party websites or services that are not owned or controlled by Electronio. This Privacy Policy does not apply to such third-party platforms, and we encourage you to review their privacy policies before interacting with them."
        ),
        PrivacyAndPolicyModel(
            "6. Children's Privacy",
            "The App is not intended for use by children under the age of 13. We do not knowingly collect personal information from children. If you believe we have inadvertently collected information from a child, please contact us immediately, and we will take appropriate steps to remove such information."
        ),
        PrivacyAndPolicyModel(
            "7. Changes to this Privacy Policy",
            "We reserve the right to update or modify this Privacy Policy from time to time. Any changes will be effective when we post the revised policy in the App. We encourage you to review this page periodically for any updates."
        ),
        PrivacyAndPolicyModel(
            "8. Contact Us",
            "If you have any questions, concerns, or requests regarding this Privacy Policy or the App's privacy practices, please contact us "
        )
    )
}

